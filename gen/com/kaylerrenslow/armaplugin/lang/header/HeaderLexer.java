/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package com.kaylerrenslow.armaplugin.lang.header;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.kaylerrenslow.armaplugin.lang.header.psi.HeaderTypes;
import com.kaylerrenslow.armaplugin.lang.header.psi.HeaderParserDefinition;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>header.flex</tt>
 */
public class HeaderLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 14848 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\23\1\24\1\21\14\25\1\26\50\25\1\27\2\25\1\30\1\31\1\32\1\33"+
    "\25\25\1\34\20\21\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\21\1\44\1\45\1\46\1"+
    "\21\1\47\2\21\1\50\4\21\1\25\1\51\1\52\5\21\2\25\1\53\31\21\1\25\1\54\1\21"+
    "\1\55\40\21\1\56\17\21\1\57\1\60\1\61\1\62\13\21\1\63\10\21\123\25\1\64\7"+
    "\25\1\65\1\66\37\21\1\25\1\66\u0582\21\1\67\u017f\21");

  /* The ZZ_CMAP_Y table has 3584 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\0\1\2\1\3\1\4\1\5\1\6\1\7\2\10\1\11\1\12\1\13\1\14\1\15\1\16\3"+
    "\0\1\17\1\20\1\21\1\22\2\23\1\24\3\23\1\24\71\23\1\25\1\23\1\26\1\27\1\30"+
    "\1\31\2\27\16\0\1\32\1\17\1\33\1\34\2\23\1\35\11\23\1\36\21\23\1\37\1\40\23"+
    "\23\1\27\1\41\3\23\1\24\1\42\1\41\4\23\1\43\1\44\4\0\1\45\1\46\1\27\3\23\2"+
    "\47\1\27\1\50\1\51\1\0\1\52\5\23\1\53\3\0\1\54\1\55\13\23\1\56\1\45\1\57\1"+
    "\60\1\0\1\61\1\27\1\62\1\63\3\23\3\0\1\64\12\23\1\65\1\0\1\66\1\27\1\0\1\67"+
    "\3\23\1\53\1\70\1\22\2\23\1\65\1\71\1\72\1\73\2\27\3\23\1\74\10\27\1\75\1"+
    "\30\6\27\1\76\2\0\1\77\1\100\6\23\1\101\2\0\1\102\1\23\1\103\1\0\2\41\1\104"+
    "\1\105\1\106\2\23\1\75\1\107\1\110\1\111\1\112\1\62\1\113\1\103\1\0\1\114"+
    "\1\51\1\104\1\115\1\106\2\23\1\75\1\116\1\117\1\120\1\121\1\122\1\123\1\124"+
    "\1\0\1\125\1\27\1\104\1\36\1\35\2\23\1\75\1\126\1\110\1\45\1\127\1\130\1\27"+
    "\1\103\1\0\1\42\1\27\1\104\1\105\1\106\2\23\1\75\1\126\1\110\1\111\1\121\1"+
    "\124\1\113\1\103\1\0\1\42\1\27\1\131\1\132\1\133\1\134\1\135\1\132\1\23\1"+
    "\136\1\137\1\140\1\141\1\27\1\124\1\0\1\27\1\42\1\104\1\32\1\75\2\23\1\75"+
    "\1\142\1\143\1\144\1\140\1\145\1\26\1\103\1\0\2\27\1\146\1\32\1\75\2\23\1"+
    "\75\1\142\1\110\1\144\1\140\1\145\1\33\1\103\1\0\1\147\1\27\1\146\1\32\1\75"+
    "\4\23\1\150\1\144\1\151\1\62\1\27\1\103\1\0\1\27\1\40\1\146\1\23\1\24\1\40"+
    "\2\23\1\35\1\152\1\24\1\153\1\154\1\0\2\27\1\155\1\27\1\41\5\23\1\156\1\157"+
    "\1\160\1\77\1\0\1\161\4\27\1\162\1\163\1\164\1\41\1\165\1\166\1\156\1\167"+
    "\1\170\1\171\1\0\1\172\4\27\1\130\2\27\1\161\1\0\1\161\1\173\1\174\1\23\1"+
    "\41\3\23\1\30\1\44\1\0\1\144\1\175\1\0\1\44\3\0\1\50\1\176\7\27\5\23\1\53"+
    "\1\0\1\177\1\0\1\161\1\65\1\200\1\201\1\202\1\203\1\23\1\204\1\205\1\0\1\171"+
    "\4\23\1\36\1\21\5\23\1\206\51\23\1\133\1\24\1\133\5\23\1\133\4\23\1\133\1"+
    "\24\1\133\1\23\1\24\7\23\1\133\10\23\1\207\4\27\2\23\2\27\12\23\1\30\1\27"+
    "\1\41\114\23\1\105\2\23\1\41\2\23\1\47\11\23\1\132\1\130\1\27\1\23\1\32\1"+
    "\210\1\27\2\23\1\210\1\27\2\23\1\211\1\27\1\23\1\32\1\212\1\27\6\23\1\213"+
    "\3\0\1\214\1\215\1\0\1\161\3\27\1\216\1\0\1\161\13\23\1\27\5\23\1\217\10\23"+
    "\1\220\1\27\3\23\1\30\1\0\1\2\1\0\1\2\1\124\1\0\3\23\1\220\1\30\1\27\5\23"+
    "\1\114\2\0\1\55\1\161\1\0\1\161\4\27\2\23\1\160\1\2\6\23\1\175\1\77\3\0\1"+
    "\111\1\0\1\161\1\0\1\161\1\43\13\27\1\221\5\23\1\213\1\0\1\221\1\114\1\0\1"+
    "\161\1\27\1\222\1\2\1\27\1\223\3\23\1\102\1\202\1\0\1\67\4\23\1\65\1\0\1\2"+
    "\1\27\4\23\1\213\2\0\1\27\1\0\1\224\1\0\1\67\3\23\1\220\12\27\1\225\2\0\1"+
    "\226\1\227\1\27\30\23\4\0\1\77\2\27\1\76\42\23\2\220\4\23\2\220\1\23\1\230"+
    "\3\23\1\220\6\23\1\32\1\170\1\231\1\30\1\232\1\114\1\23\1\30\1\231\1\30\1"+
    "\27\1\222\3\27\1\233\1\27\1\43\1\130\1\27\1\234\1\27\1\50\1\235\1\42\1\43"+
    "\2\27\1\23\1\30\3\23\1\47\2\27\1\0\1\50\1\236\1\0\1\237\1\27\1\240\1\40\1"+
    "\152\1\241\1\31\1\242\1\23\1\243\1\244\1\245\2\27\5\23\1\130\116\27\5\23\1"+
    "\24\5\23\1\24\20\23\1\30\1\246\1\247\1\27\4\23\1\36\1\21\7\23\1\43\1\27\1"+
    "\62\2\23\1\24\1\27\10\24\4\0\5\27\1\43\72\27\1\244\3\27\1\41\1\204\1\241\1"+
    "\30\1\41\11\23\1\24\1\250\1\41\12\23\1\206\1\244\4\23\1\220\1\41\12\23\1\24"+
    "\2\27\3\23\1\47\6\27\170\23\1\220\11\27\71\23\1\30\6\27\21\23\1\30\10\27\5"+
    "\23\1\220\41\23\1\30\2\23\1\0\1\247\2\27\5\23\1\160\1\76\1\251\3\23\1\62\12"+
    "\23\1\161\3\27\1\43\1\23\1\40\14\23\1\252\1\114\1\27\1\23\1\47\11\27\1\23"+
    "\1\253\1\254\2\23\1\53\2\27\1\130\6\23\1\114\1\27\1\67\5\23\1\213\1\0\1\50"+
    "\1\27\1\0\1\161\2\0\1\67\1\51\1\0\1\67\2\23\1\65\1\171\2\23\1\160\1\0\1\2"+
    "\1\27\3\23\1\30\1\100\5\23\1\53\1\0\1\237\1\43\1\0\1\161\4\27\5\23\1\102\1"+
    "\77\1\27\1\254\1\255\1\0\1\161\2\23\1\24\1\256\6\23\1\201\1\257\1\217\2\27"+
    "\1\260\1\23\1\53\1\261\1\27\3\262\1\27\2\24\22\27\4\23\1\53\1\263\1\0\1\161"+
    "\64\23\1\114\1\27\2\23\1\24\1\264\5\23\1\114\40\27\55\23\1\220\15\23\1\26"+
    "\4\27\1\24\1\27\1\264\1\265\1\23\1\75\1\24\1\170\1\266\15\23\1\26\3\27\1\264"+
    "\54\23\1\220\2\27\10\23\1\40\6\23\5\27\1\23\1\30\2\0\2\27\1\77\1\27\1\135"+
    "\2\27\1\244\3\27\1\42\1\32\20\23\1\267\1\234\1\27\1\0\1\161\1\41\2\23\1\115"+
    "\1\41\2\23\1\47\1\270\12\23\1\24\3\40\1\271\1\272\2\27\1\273\1\23\1\142\2"+
    "\23\1\24\2\23\1\274\1\23\1\220\1\23\1\220\4\27\17\23\1\47\10\27\6\23\1\30"+
    "\20\27\1\275\20\27\3\23\1\30\6\23\1\130\5\27\3\23\1\24\2\27\3\23\1\47\6\27"+
    "\3\23\1\220\4\23\1\114\1\23\1\241\5\27\23\23\1\220\1\0\1\161\52\27\1\220\1"+
    "\75\4\23\1\36\1\276\2\23\1\220\25\27\2\23\1\220\1\27\3\23\1\26\10\27\7\23"+
    "\1\270\10\27\1\277\1\76\1\142\1\41\2\23\1\114\1\120\4\27\3\23\1\30\20\27\6"+
    "\23\1\220\1\27\2\23\1\220\1\27\2\23\1\47\21\27\11\23\1\130\66\27\1\223\6\23"+
    "\1\0\1\77\3\27\1\124\1\0\2\27\1\223\5\23\1\0\1\300\2\27\3\23\1\130\1\0\1\161"+
    "\1\223\3\23\1\160\1\0\1\144\1\0\10\27\1\223\5\23\1\53\1\0\1\301\1\27\1\0\1"+
    "\161\24\27\5\23\1\53\1\0\1\27\1\0\1\161\46\27\55\23\1\24\22\27\14\23\1\47"+
    "\63\27\5\23\1\24\72\27\7\23\1\130\130\27\10\23\1\30\1\27\1\102\4\0\1\77\1"+
    "\27\1\62\1\223\1\23\14\27\1\26\153\27\1\302\1\303\2\0\1\304\1\2\3\27\1\305"+
    "\22\27\1\306\67\27\12\23\1\32\10\23\1\32\1\307\1\310\1\23\1\311\1\142\7\23"+
    "\1\36\1\312\2\32\3\23\1\313\1\170\1\40\1\75\51\23\1\220\3\23\1\75\2\23\1\206"+
    "\3\23\1\206\2\23\1\32\3\23\1\32\2\23\1\24\3\23\1\24\3\23\1\75\3\23\1\75\2"+
    "\23\1\206\1\314\6\0\1\142\3\23\1\162\1\41\1\206\1\315\1\240\1\316\1\162\1"+
    "\230\1\162\2\206\1\123\1\23\1\35\1\23\1\114\1\317\1\35\1\23\1\114\50\27\32"+
    "\23\1\24\5\27\106\23\1\30\1\27\33\23\1\220\74\27\1\122\3\27\14\0\20\27\36"+
    "\0\2\27");

  /* The ZZ_CMAP_A table has 1664 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\2\1\6\1\5\1\42\1\6\1\4\6\2\4\0\1\6\1\0\1\20\1\3\1\22\3\0\1\33\1\34\1\10"+
    "\1\30\1\37\1\14\1\12\1\7\1\15\11\11\1\40\1\41\1\0\1\27\3\0\4\17\1\13\1\17"+
    "\11\22\1\16\2\22\1\35\1\21\1\36\1\0\1\22\1\0\1\25\1\17\1\23\1\17\1\13\1\17"+
    "\5\22\1\24\6\22\1\26\4\22\1\16\2\22\1\31\1\0\1\32\1\0\6\2\1\43\2\2\2\0\4\1"+
    "\4\0\1\1\2\0\1\2\7\0\1\1\4\0\1\1\5\0\17\1\1\0\2\1\4\0\4\1\16\0\5\1\7\0\1\1"+
    "\1\0\1\1\1\0\5\1\1\0\2\1\6\0\1\1\1\0\3\1\1\0\1\1\1\0\4\1\1\0\13\1\1\0\3\1"+
    "\1\0\5\2\2\0\6\1\1\0\7\1\1\0\1\1\15\0\1\1\1\0\15\2\1\0\1\2\1\0\2\2\1\0\2\2"+
    "\1\0\1\2\3\1\5\0\5\2\6\0\1\1\4\0\3\2\5\0\3\1\7\2\4\0\2\1\1\2\13\1\1\0\1\1"+
    "\7\2\2\1\2\2\1\0\4\2\2\1\2\2\3\1\2\0\1\1\7\0\1\2\1\1\1\2\6\1\3\2\2\0\11\1"+
    "\3\2\1\1\6\0\2\2\6\1\4\2\2\1\2\0\2\2\1\1\11\2\1\1\3\2\1\1\5\2\2\0\1\1\3\2"+
    "\4\0\1\1\1\0\6\1\4\0\13\2\1\0\4\2\6\1\3\2\1\1\2\2\1\1\7\2\2\1\2\2\2\0\2\2"+
    "\1\0\3\2\1\0\10\1\2\0\2\1\2\0\6\1\1\0\1\1\3\0\4\1\2\0\1\2\1\1\7\2\2\0\2\2"+
    "\2\0\3\2\1\1\5\0\2\1\1\0\5\1\4\0\3\1\4\0\2\1\1\0\2\1\1\0\2\1\1\0\2\1\2\0\1"+
    "\2\1\0\5\2\4\0\2\2\2\0\3\2\3\0\1\2\7\0\4\1\1\0\1\1\7\0\4\2\3\1\1\2\2\0\1\1"+
    "\1\0\2\1\1\0\3\1\2\2\1\0\3\2\2\0\1\1\11\0\1\2\1\1\1\0\6\1\3\0\3\1\1\0\4\1"+
    "\3\0\2\1\1\0\1\1\1\0\2\1\3\0\2\1\3\0\2\1\4\0\5\2\3\0\3\2\1\0\4\2\2\0\1\1\6"+
    "\0\1\2\4\1\1\0\5\1\3\0\1\1\7\2\1\0\2\2\5\0\2\2\3\0\2\2\1\0\3\1\1\0\2\1\5\0"+
    "\3\1\2\0\1\1\3\2\1\0\4\2\1\1\1\0\4\1\1\0\1\1\4\0\1\2\4\0\6\2\1\0\1\2\3\0\2"+
    "\2\4\0\1\1\1\2\2\1\7\2\4\0\10\1\3\2\7\0\2\1\1\0\1\1\2\0\2\1\1\0\1\1\2\0\1"+
    "\1\6\0\4\1\1\0\3\1\1\0\1\1\1\0\1\1\2\0\2\1\1\0\3\1\2\2\1\0\2\2\1\1\2\0\5\1"+
    "\1\0\1\1\1\0\6\2\2\0\2\2\2\0\4\1\5\0\1\2\1\0\1\2\1\0\1\2\4\0\2\2\5\1\3\2\6"+
    "\0\1\2\1\0\7\2\1\1\2\2\4\1\3\2\1\1\3\2\2\1\7\2\3\1\4\2\5\1\14\2\1\1\1\2\3"+
    "\1\1\0\7\1\2\0\3\2\2\1\3\2\3\0\2\1\2\2\4\0\1\1\1\0\2\2\4\0\4\1\10\2\3\0\1"+
    "\1\3\0\2\1\1\2\5\0\3\2\2\0\1\1\1\2\1\1\5\0\6\1\2\0\5\2\3\1\3\0\10\2\5\1\2"+
    "\2\3\0\3\1\3\2\1\0\5\2\4\1\1\2\4\1\3\2\2\1\2\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1"+
    "\2\0\3\1\1\0\6\1\2\0\2\1\2\42\5\2\5\0\1\1\5\0\6\2\1\0\1\2\3\0\4\2\11\0\1\1"+
    "\4\0\1\1\1\0\5\1\2\0\1\1\1\0\4\1\1\0\3\1\2\0\4\1\5\0\5\1\4\0\1\1\4\0\4\1\3"+
    "\2\2\1\5\0\2\2\2\0\3\1\6\2\1\0\2\1\2\0\4\1\1\0\2\1\1\2\3\1\1\2\4\1\1\2\10"+
    "\1\2\2\4\0\1\1\1\2\4\0\1\2\5\1\2\2\3\0\3\1\4\0\3\1\2\2\2\0\6\1\1\0\3\2\1\0"+
    "\2\2\5\0\5\1\5\0\1\1\1\2\3\1\1\0\2\1\1\0\7\1\2\0\1\2\6\0\2\1\2\0\3\1\3\0\2"+
    "\1\3\0\2\1\2\0\3\2\4\0\3\1\1\0\2\1\1\0\1\1\5\0\1\2\2\0\1\1\3\0\1\1\2\0\2\1"+
    "\3\2\1\0\2\2\1\0\3\2\2\0\1\2\2\0\1\2\4\1\10\0\5\2\3\0\6\2\2\0\3\2\2\0\4\2"+
    "\4\0\3\2\5\0\1\1\2\0\2\1\2\0\4\1\1\0\4\1\1\0\1\1\1\0\6\1\2\0\5\1\1\0\4\1\1"+
    "\0\4\1\2\0\2\2\1\0\1\1\1\0\1\1\5\0\1\1\1\0\1\1\1\0\3\1\1\0\3\1\1\0\3\1");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\1\1\7\1\6\1\1\1\2\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\1\1\16\1\17\1\20\1\0"+
    "\1\21\1\22\2\0\2\6\2\0\1\23\1\2\1\24"+
    "\1\25\1\0\1\21\1\0\1\6\2\26\1\2\1\21"+
    "\1\27\1\26\1\2\1\26\1\30\5\26";

  private static int [] zzUnpackAction() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\44\0\110\0\154\0\220\0\264\0\44\0\330"+
    "\0\374\0\44\0\u0120\0\u0144\0\u0168\0\44\0\u018c\0\44"+
    "\0\44\0\44\0\44\0\u01b0\0\44\0\44\0\44\0\u01d4"+
    "\0\u01f8\0\u021c\0\u0240\0\374\0\u0264\0\u0288\0\u02ac\0\u0144"+
    "\0\u02d0\0\u02f4\0\44\0\44\0\u0318\0\u033c\0\u0360\0\u0384"+
    "\0\u03a8\0\u02ac\0\u03cc\0\u03f0\0\44\0\u0414\0\u0438\0\u045c"+
    "\0\110\0\u0480\0\u04a4\0\u04c8\0\u04ec\0\44";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\3\5\1\6\1\7\1\10"+
    "\1\11\1\3\1\12\1\13\2\3\1\14\1\2\1\3"+
    "\1\15\3\3\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\2\1\25\1\26\1\27\47\0\2\3\1\30"+
    "\5\0\1\3\1\0\1\3\1\0\3\3\2\0\5\3"+
    "\14\0\1\3\11\0\1\31\1\0\1\31\1\0\3\31"+
    "\2\0\5\31\21\0\3\5\44\0\1\32\1\33\44\0"+
    "\1\10\1\34\1\35\1\0\1\10\37\0\1\36\3\0"+
    "\1\36\37\0\1\10\1\34\1\35\1\0\1\10\1\37"+
    "\25\0\20\40\1\41\23\40\1\0\2\3\1\30\5\0"+
    "\1\3\1\0\1\3\1\0\3\3\2\0\2\3\1\42"+
    "\2\3\14\0\1\3\27\0\1\43\52\0\1\44\10\0"+
    "\1\45\40\0\4\31\2\0\13\31\1\46\22\31\4\32"+
    "\2\0\36\32\10\33\1\47\33\33\11\0\1\50\2\0"+
    "\2\50\12\0\1\50\24\0\1\36\1\0\1\35\1\0"+
    "\1\36\37\0\1\51\1\0\1\51\1\0\1\52\1\0"+
    "\1\51\3\0\1\51\1\0\1\51\36\0\1\40\24\0"+
    "\2\3\1\30\5\0\1\3\1\0\1\3\1\0\3\3"+
    "\2\0\3\3\1\53\1\3\14\0\1\3\1\0\2\3"+
    "\6\0\1\3\1\0\1\3\1\0\3\3\2\0\5\3"+
    "\14\0\1\3\4\31\1\54\14\31\1\46\22\31\7\33"+
    "\1\55\1\47\33\33\11\0\1\50\3\0\1\50\37\0"+
    "\1\56\1\0\1\56\1\0\1\56\1\0\1\56\3\0"+
    "\1\56\1\0\1\56\17\0\2\3\1\30\5\0\1\3"+
    "\1\0\1\3\1\0\3\3\2\0\4\3\1\57\14\0"+
    "\1\3\4\31\1\0\14\31\1\46\22\31\11\0\1\60"+
    "\1\0\1\60\1\0\1\60\1\0\1\60\3\0\1\60"+
    "\1\0\1\60\17\0\2\3\1\30\5\0\1\3\1\0"+
    "\1\3\1\0\3\3\2\0\4\3\1\61\14\0\1\3"+
    "\11\0\1\62\1\0\1\62\1\0\1\62\1\0\1\62"+
    "\3\0\1\62\1\0\1\62\27\0\1\63\1\0\1\63"+
    "\1\0\1\63\1\0\1\63\3\0\1\63\1\0\1\63"+
    "\27\0\1\64\1\0\1\64\1\0\1\64\1\0\1\64"+
    "\3\0\1\64\1\0\1\64\27\0\1\65\1\0\1\65"+
    "\1\0\1\65\1\0\1\65\3\0\1\65\1\0\1\65"+
    "\27\0\1\66\1\0\1\66\1\0\1\66\1\0\1\66"+
    "\3\0\1\66\1\0\1\66\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1296];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\1\11\2\1\1\11\3\1\1\11"+
    "\1\1\4\11\1\1\3\11\1\0\2\1\2\0\2\1"+
    "\2\0\2\1\2\11\1\0\1\1\1\0\5\1\1\11"+
    "\10\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public HeaderLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
        return;

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            }
          case 25: break;
          case 2: 
            { return HeaderTypes.IDENTIFIER;
            }
          case 26: break;
          case 3: 
            { return TokenType.WHITE_SPACE;
            }
          case 27: break;
          case 4: 
            { return HeaderTypes.FSLASH;
            }
          case 28: break;
          case 5: 
            { return HeaderTypes.ASTERISK;
            }
          case 29: break;
          case 6: 
            { return HeaderTypes.NUMBER_LITERAL;
            }
          case 30: break;
          case 7: 
            { return HeaderTypes.MINUS;
            }
          case 31: break;
          case 8: 
            { return HeaderTypes.EQ;
            }
          case 32: break;
          case 9: 
            { return HeaderTypes.PLUS;
            }
          case 33: break;
          case 10: 
            { return HeaderTypes.LBRACE;
            }
          case 34: break;
          case 11: 
            { return HeaderTypes.RBRACE;
            }
          case 35: break;
          case 12: 
            { return HeaderTypes.LPAREN;
            }
          case 36: break;
          case 13: 
            { return HeaderTypes.RPAREN;
            }
          case 37: break;
          case 14: 
            { return HeaderTypes.COMMA;
            }
          case 38: break;
          case 15: 
            { return HeaderTypes.COLON;
            }
          case 39: break;
          case 16: 
            { return HeaderTypes.SEMICOLON;
            }
          case 40: break;
          case 17: 
            { return HeaderTypes.MACRO;
            }
          case 41: break;
          case 18: 
            { return HeaderParserDefinition.INLINE_COMMENT;
            }
          case 42: break;
          case 19: 
            { return HeaderTypes.STRING_LITERAL;
            }
          case 43: break;
          case 20: 
            { return HeaderTypes.PLUS_EQ;
            }
          case 44: break;
          case 21: 
            { return HeaderTypes.BRACKET_PAIR;
            }
          case 45: break;
          case 22: 
            { return HeaderTypes.HEX_LITERAL;
            }
          case 46: break;
          case 23: 
            { return HeaderParserDefinition.BLOCK_COMMENT;
            }
          case 47: break;
          case 24: 
            { return HeaderTypes.CLASS;
            }
          case 48: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
