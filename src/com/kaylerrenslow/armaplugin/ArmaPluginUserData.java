package com.kaylerrenslow.armaplugin;

import com.intellij.openapi.application.TransactionGuard;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtil;
import com.kaylerrenslow.armaDialogCreator.arma.header.HeaderFile;
import com.kaylerrenslow.armaDialogCreator.arma.header.HeaderParser;
import com.kaylerrenslow.armaplugin.lang.header.HeaderConfigFunction;
import com.kaylerrenslow.armaplugin.lang.header.psi.HeaderPsiFile;
import com.kaylerrenslow.armaplugin.settings.ArmaPluginApplicationSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * Used for storing data collected from the current IntelliJ process's lifetime.
 * This data will not be persisted after IntelliJ restarts.
 *
 * @author Kayler
 * @since 09/08/2017
 */
public class ArmaPluginUserData {
	private static final ArmaPluginUserData instance = new ArmaPluginUserData();

	@NotNull
	public static ArmaPluginUserData getInstance() {
		return instance;
	}

	private final Map<Module, ArmaPluginModuleData> moduleMap = new IdentityHashMap<>();

	/**
	 * Get a list of {@link HeaderFile} instances. It will be either a single description.ext (for missions)
	 * or multiple config.cpp (for addons/mods).
	 * Note: this method will reparse only if it is unset or out of date (file was updated).
	 *
	 * @return the root config file, or an empty list if couldn't locate a {@link Module} or couldn't be parsed
	 */
	@NotNull
	public List<HeaderFile> parseAndGetConfigHeaderFiles(@NotNull PsiElement elementFromModule) {
		synchronized (this) {
			ArmaPluginModuleData moduleData = getModuleData(elementFromModule);
			if (moduleData == null) {
				return Collections.emptyList();
			}
			if (!moduleData.shouldReparseConfigHeaderFiles() && moduleData.getConfigHeaderFiles() != null) {
				return moduleData.getConfigHeaderFiles();
			}

			//find a place to save parse data
			String imlDir = ArmaPlugin.getPathToTempDirectory(moduleData.getModule());
			if (imlDir == null) {
				return Collections.emptyList();
			}
			List<VirtualFile> rootConfigVirtualFiles = ArmaPluginUtil.getConfigVirtualFiles(elementFromModule);
			if (rootConfigVirtualFiles.isEmpty()) {
				return Collections.emptyList();
			}

			//the contents in the header files aren't always saved to file by intellij by the time this method is invoked,
			//so we are going to force save the documents
			CompletableFuture<List<HeaderFile>> future = new CompletableFuture<>();
			TransactionGuard.submitTransaction(() -> {/*Disposable class here*/}, /*Runnable*/() -> {
				FileDocumentManager manager = FileDocumentManager.getInstance();
				for (Document document : manager.getUnsavedDocuments()) {
					VirtualFile virtFile = manager.getFile(document);
					if (virtFile == null) {
						continue;
					}
					PsiFile psiFile = PsiUtil.getPsiFile(moduleData.getModule().getProject(), virtFile);
					if (psiFile instanceof HeaderPsiFile) {
						manager.saveDocument(document);
					}
				}

				//parse the root config
				try {
					List<HeaderFile> parsedFiles = new ArrayList<>();
					for (VirtualFile rootConfigVirtualFile : rootConfigVirtualFiles) {
						HeaderFile file = HeaderParser.parse(new File(rootConfigVirtualFile.getPath()), new File(imlDir));
						parsedFiles.add(file);
					}
					moduleData.setConfigHeaderFiles(parsedFiles);
					moduleData.setReparseConfigHeaderFiles(false);
					future.complete(moduleData.getConfigHeaderFiles());

//					new DialogWrapper(elementFromModule.getProject()){
//						@Override
//						protected JComponent createCenterPanel() {
//							init();
//							this.createDefaultActions();
//							return new JLabel("preprocessed");
//						}
//					}.show();
				} catch (Exception e) {
					System.out.println("Header Parse Exception:" + e.getMessage());
					future.complete(null);
				}

			});

			//using a future to ensure memory visibility
			//note: using .get() or .get(long,TimeUnit) is making the transaction take a very long time.
			return future.getNow(null);
		}
	}

	@Nullable
	public List<HeaderConfigFunction> getAllConfigFunctions(@NotNull PsiElement elementFromModule) {
		synchronized (this) {
			ArmaPluginModuleData moduleData = getModuleData(elementFromModule);
			if (moduleData == null) {
				return null;
			}
			if (moduleData.getConfigHeaderFiles() == null || moduleData.shouldReparseConfigHeaderFiles()) {
				parseAndGetConfigHeaderFiles(elementFromModule);
			}
			return moduleData.getAllConfigFunctions();
		}
	}

	@Nullable
	private ArmaPluginModuleData getModuleData(@NotNull PsiElement elementFromModule) {
		Module module = ModuleUtil.findModuleForPsiElement(elementFromModule);
		if (module == null) {
			return null;
		}
		return moduleMap.computeIfAbsent(module, module1 -> {
			return new ArmaPluginModuleData(module);
		});
	}

	/**
	 * Invoke when the root config file ({@link #parseAndGetConfigHeaderFiles(PsiElement)}) or included files for it has been edited.
	 * Note that this doesn't do any reparsing and instead tells {@link #parseAndGetConfigHeaderFiles(PsiElement)} that it's cached
	 * {@link HeaderFile} is no longer valid and it should reparse.
	 */
	public void reparseRootConfig(@NotNull PsiFile fileFromModule) {
		synchronized (this) {
			Module module = ModuleUtil.findModuleForPsiElement(fileFromModule);
			if (module == null) {
				return;
			}
			ArmaPluginModuleData moduleData = moduleMap.computeIfAbsent(module, module1 -> {
				return new ArmaPluginModuleData(module);
			});
			moduleData.setReparseConfigHeaderFiles(true);
		}
	}

	/**
	 * This method is just a shortcut that utilizes {@link ArmaPluginApplicationSettings#getState()}
	 *
	 * @return the Arma Tools directory
	 * @see #setArmaToolsDirectory(File)
	 */
	@Nullable
	public File getArmaToolsDirectory() {
		String path = ArmaPluginApplicationSettings.getInstance().getState().armaToolsDirectory;
		if (path == null) {
			return null;
		}
		return new File(path);
	}

	/**
	 * Sets the current Arma Tools directory.
	 * This method is just a shortcut that utilizes {@link ArmaPluginApplicationSettings#getState()}
	 *
	 * @see #getArmaToolsDirectory()
	 */
	public void setArmaToolsDirectory(@Nullable File armaToolsDir) {
		String path = armaToolsDir == null ? null : armaToolsDir.getAbsolutePath();
		ArmaPluginApplicationSettings.getInstance().getState().armaToolsDirectory = path;
	}
}
