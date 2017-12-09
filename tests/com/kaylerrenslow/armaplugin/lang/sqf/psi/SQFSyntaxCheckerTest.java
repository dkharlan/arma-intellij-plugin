package com.kaylerrenslow.armaplugin.lang.sqf.psi;

import com.kaylerrenslow.armaplugin.lang.sqf.syntax.*;

import java.util.Arrays;

import static com.kaylerrenslow.armaplugin.lang.sqf.syntax.ValueType.BaseType;

/**
 * Tests for syntax/type checking for {@link SQFFile} instances
 *
 * @author Kayler
 * @since 11/15/2017
 */
public class SQFSyntaxCheckerTest extends SQFSyntaxCheckerTestHelper {

	//----START Literal Expression----
	public void testLiteralExpression_number() throws Exception {
		ValueType ret = getExitTypeForText("1");
		assertEquals(ValueType.BaseType.NUMBER, ret);
	}

	public void testLiteralExpression_string() throws Exception {
		ValueType ret = getExitTypeForText("'hello'");
		assertEquals(ValueType.BaseType.STRING, ret);
	}

	public void testLiteralExpression_array() throws Exception {
		ValueType ret = getExitTypeForText("[1,2,3]");

		ValueType t = new ExpandedValueType(ValueType.BaseType.NUMBER, ValueType.BaseType.NUMBER, BaseType.NUMBER);

		assertEquals(t, ret);
	}

	//----END Literal Expression----

	//----START Paren Expression----

	public void testParenExpression1() throws Exception {
		ValueType ret = getExitTypeForText("(1)");
		assertEquals(BaseType.NUMBER, ret);
	}

	public void testParenExpression2() throws Exception {
		ValueType ret = getExitTypeForText("('hello')");
		assertEquals(BaseType.STRING, ret);
	}

	public void testParenExpression3() throws Exception {
		ValueType ret = getExitTypeForText("([1,2,3])");
		ValueType t = new ExpandedValueType(ValueType.BaseType.NUMBER, BaseType.NUMBER, BaseType.NUMBER);

		assertEquals(t, ret);
	}

	public void testParenExpression4() throws Exception {
		ValueType ret = getExitTypeForText("(1+1)");
		assertEquals(BaseType.NUMBER, ret);
	}

	//----END Paren Expression----

	//----START Add Expression----

	public void testAddExpression_valid_number() throws Exception {
		assertNoProblems("1+1");
	}

	public void testAddExpression_valid_string() throws Exception {
		assertNoProblems("''+''");
	}

	public void testAddExpression_valid_array() throws Exception {
		assertNoProblems("[]+[]");
	}

	public void testAddExpression_valid_variable() throws Exception {
		assertNoProblems("_var+_var");
		assertNoProblems("1+_var");
		assertNoProblems("[]+_var");
		assertNoProblems("''+_var");
		assertNoProblems("_var+1");
		assertNoProblems("_var+[]");
		assertNoProblems("_var+''");
	}

	public void testAddExpression_bad_numAndString() throws Exception {
		assertHasProblems("1e1+''");
		assertHasProblems("''+1e1");
	}

	public void testAddExpression_bad_numAndArray() throws Exception {
		assertHasProblems("0.5+[]");
		assertHasProblems("[]+0.5");
	}

	public void testAddExpression_bad_stringAndArray() throws Exception {
		assertHasProblems("'hi'+[]");
		assertHasProblems("[]+'hello'");
	}

	//----END Add Expression----

	//----START Sub Expression----

	public void testSubExpression_valid_number() throws Exception {
		assertNoProblems("1-1");
	}

	public void testSubExpression_valid_array() throws Exception {
		assertNoProblems("[]-[]");
	}

	public void testSubExpression_valid_variable() throws Exception {
		assertNoProblems("_var-_var");
		assertNoProblems("1-_var");
		assertNoProblems("[]-_var");
		assertNoProblems("_var-1");
		assertNoProblems("_var-[]");
	}

	public void testSubExpression_bad_numAndString() throws Exception {
		assertHasProblems("1e1-''");
		assertHasProblems("''-1e1");
	}

	public void testSubExpression_bad_numAndArray() throws Exception {
		assertHasProblems("0.5-[]");
		assertHasProblems("[]-0.5");
	}

	//----END Sub Expression----

	//----START Mult Expression----
	public void testMultExpression_valid() throws Exception {
		assertNoProblems("0*1.5");
	}

	public void testMultExpression_bad() throws Exception {
		assertHasProblems("0*[]");
		assertHasProblems("[]*0");
	}

	public void testMultExpression_valid_variable() throws Exception {
		assertNoProblems("_var*_var");
		assertNoProblems("1*_var");
		assertNoProblems("_var*1");
	}
	//----END Mult Expression----

	//----START Mod Expression----
	public void testModExpression_valid() throws Exception {
		assertNoProblems("0%1.5");
	}

	public void testModExpression_bad() throws Exception {
		assertHasProblems("0%[]");
		assertHasProblems("[]%0");
	}

	public void testModExpression_valid_variable() throws Exception {
		assertNoProblems("_var%_var");
		assertNoProblems("1%_var");
		assertNoProblems("_var%1");
	}
	//----END Mod Expression----

	//----START Div Expression----
	public void testDivExpression_valid_number() throws Exception {
		assertNoProblems("0/1.5");
	}

	public void testDivExpression_valid_config() throws Exception {
		assertNoProblems("configFile/'CfgVehicles'");
		assertNoProblems("_var/'test'");
	}

	public void testDivExpression_bad_config() throws Exception {
		assertHasProblems("'test'/_var");
		assertHasProblems("'test'/configFile");
		assertHasProblems("0/configFile");
		assertHasProblems("configFile/0");
	}

	public void testDivExpression_bad_number() throws Exception {
		assertHasProblems("0/[]");
		assertHasProblems("[]/0");
	}

	public void testDivExpression_valid_number_variable() throws Exception {
		assertNoProblems("_var/_var");
		assertNoProblems("1/_var");
		assertNoProblems("_var/1");
	}

	//----END Div Expression----

	//----START Bool And Expression----
	public void testBoolAndExpression_valid() throws Exception {
		assertNoProblems("true && true");
		assertNoProblems("true && false");
		assertNoProblems("false && {true}");
	}

	public void testBoolAndExpression_bad() throws Exception {
		assertHasProblems("true && 1");
		assertHasProblems("true && []");
		assertHasProblems("false && {5}");
	}

	public void testBoolAndExpression_valid_variable() throws Exception {
		assertNoProblems("_var && _var");
		assertNoProblems("_var && {_var}");
		assertNoProblems("true && _var");
		assertNoProblems("true && {_var}");
	}

	//----END Bool And Expression----

	//----START Bool Or Expression----
	public void testBoolOrExpression_valid() throws Exception {
		assertNoProblems("true || true");
		assertNoProblems("true || false");
		assertNoProblems("false || {true}");
	}

	public void testBoolOrExpression_bad() throws Exception {
		assertHasProblems("true || 1");
		assertHasProblems("true || []");
		assertHasProblems("false || {5}");
	}

	public void testBoolOrExpression_valid_variable() throws Exception {
		assertNoProblems("_var || _var");
		assertNoProblems("_var || {_var}");
		assertNoProblems("true || _var");
		assertNoProblems("true || {_var}");
	}
	//----END Bool Or Expression----

	//----START Bool Not Expression----
	public void testBoolNotExpression_valid() throws Exception {
		assertNoProblems("!true");
		assertNoProblems("!(true || false)");
		assertNoProblems("!(false || {true})");

		assertNoProblems("!_var");
	}

	public void testBoolNotExpression_bad() throws Exception {
		assertHasProblems("!1");
		assertHasProblems("![]");
		assertHasProblems("!{5}");
		assertHasProblems("!{true}");
	}
	//----END Bool Not Expression----

	//----START Comp Expression----
	public void testCompExpression_valid() throws Exception {
		assertNoProblems("1 < 1");
		assertNoProblems("1 < 0.5");

		assertNoProblems("1 <= 10");
		assertNoProblems("1 <= 0.5");

		assertNoProblems("1 > 1");
		assertNoProblems("1 > 0.5");

		assertNoProblems("1 >= 10");
		assertNoProblems("1 >= 0.5");

		assertNoProblems("1==1"); //number
		assertNoProblems("''==''"); //string

		{ //group
			assertEquals(ValueType.BaseType.GROUP, getExitTypeForText("grpNull"));
			assertNoProblems("grpNull==grpNull");
			assertNoProblems("grpNull!=grpNull");
		}

		{ //side
			assertEquals(BaseType.SIDE, getExitTypeForText("west"));
			assertNoProblems("west==west");
			assertNoProblems("west!=west");
		}

		{ //object
			assertEquals(BaseType.OBJECT, getExitTypeForText("objNull"));
			assertNoProblems("objNull==objNull");
			assertNoProblems("objNull!=objNull");
		}

		{ //config
			assertEquals(BaseType.CONFIG, getExitTypeForText("configFile"));
			assertNoProblems("configFile==configFile");
			assertNoProblems("configFile!=configFile");
		}

		{ //display
			assertEquals(ValueType.BaseType.DISPLAY, getExitTypeForText("displayNull"));
			assertNoProblems("displayNull==displayNull");
			assertNoProblems("displayNull!=displayNull");
		}

		{ //control
			assertEquals(ValueType.BaseType.CONTROL, getExitTypeForText("controlNull"));
			assertNoProblems("controlNull==controlNull");
			assertNoProblems("controlNull!=controlNull");
		}

		{ //location
			assertEquals(ValueType.BaseType.LOCATION, getExitTypeForText("locationNull"));
			assertNoProblems("locationNull==locationNull");
			assertNoProblems("locationNull!=locationNull");
		}

		{ //structured text
			assertEquals(BaseType.STRUCTURED_TEXT, getExitTypeForText("parseText ''"));
			assertNoProblems("(parseText '')==(parseText '')");
			assertNoProblems("(parseText '')!=(parseText '')");
		}

	}

	public void testCompExpression_bad() throws Exception {
		assertHasProblems("1 < ''");
		assertHasProblems("1 < []");
		assertHasProblems("'' < []");
		assertHasProblems("[] < 1");
		assertHasProblems("[] < []");

		assertHasProblems("1 <= ''");
		assertHasProblems("1 <= []");
		assertHasProblems("'' <= []");
		assertHasProblems("[] <= 1");
		assertHasProblems("[] <= []");

		assertHasProblems("1 > ''");
		assertHasProblems("1 > []");
		assertHasProblems("'' > []");
		assertHasProblems("[] > 1");
		assertHasProblems("[] > []");

		assertHasProblems("1 >= ''");
		assertHasProblems("1 >= []");
		assertHasProblems("'' >= []");
		assertHasProblems("[] >= 1");
		assertHasProblems("[] >= []");

		assertHasProblems("1 == ''");
		assertHasProblems("[] == []");
		assertHasProblems("1 == []");
		assertHasProblems("'' == []");
		assertHasProblems("[] == 1");
		assertHasProblems("[] == false");
		assertHasProblems("grpNull==west");
		assertHasProblems("west==grpNull");
		assertHasProblems("objNull==1");
		assertHasProblems("configFile==[]");
		assertHasProblems("displayNull==''");
		assertHasProblems("controlNull==[]");
		assertHasProblems("locationNull==false");
		assertHasProblems("(parseText '')==0");

		assertHasProblems("false == true");
		assertHasProblems("_var == true");
		assertHasProblems("true == _var");

		assertHasProblems("[] != []");
		assertHasProblems("1 != []");
		assertHasProblems("'' != []");
		assertHasProblems("[] != 1");
		assertHasProblems("[] != false");
		assertHasProblems("configFile!=[]");
		assertHasProblems("controlNull!=[]");
		assertHasProblems("1 != ''");
		assertHasProblems("grpNull!=west");
		assertHasProblems("west!=grpNull");
		assertHasProblems("objNull!=1");
		assertHasProblems("displayNull!=''");
		assertHasProblems("locationNull!=false");
		assertHasProblems("(parseText '')!=0");

		assertHasProblems("_var != true");
		assertHasProblems("true != _var");
	}

	public void testCompExpression_valid_variable() throws Exception {
		assertNoProblems("_var < _var");
		assertNoProblems("1 < _var");
		assertNoProblems("_var < 1");

		assertNoProblems("_var <= _var");
		assertNoProblems("1 <= _var");
		assertNoProblems("_var <= 1");

		assertNoProblems("_var > _var");
		assertNoProblems("1 > _var");
		assertNoProblems("_var > 1");

		assertNoProblems("_var >= _var");
		assertNoProblems("1 >= _var");
		assertNoProblems("_var >= 1");

		assertNoProblems("_var == _var");
		assertNoProblems("1 == _var");
		assertNoProblems("_var == 1");
		assertNoProblems("_var == configFile");
		assertNoProblems("configFile == _var");

		assertNoProblems("_var != _var");
		assertNoProblems("1 != _var");
		assertNoProblems("_var != 1");
		assertNoProblems("_var != configFile");
		assertNoProblems("configFile != _var");
	}
	//----END Comp Expression----

	//----START config fetch Expression----
	public void testConfigFetchExpression_valid() throws Exception {
		assertNoProblems("configFile >> ''");
		assertNoProblems("configFile >> '' >> ''");
		assertNoProblems("configFile >> '' >> '' >> ''");

		assertNoProblems("configFile >> _var >> '' >> _var");
		assertNoProblems("configFile >> _var");
		assertNoProblems("configFile >> '' >> _var >> _var");
		assertNoProblems("_var >> ''");
		assertNoProblems("_var >> _var");
	}

	public void testConfigFetchExpression_bad() throws Exception {
		assertHasProblems("configFile >> 1");
		assertHasProblems("configFile >> 1 >> 2");
		assertHasProblems("1 >> '' >> ''");
		assertHasProblems("_var >> 1 >> ''");
	}
	//----END config fetch Expression----

	//----START exponent Expression----
	public void testExponentExpression_valid() throws Exception {
		assertNoProblems("1^1");
		assertNoProblems("1^1^5");
		assertNoProblems("1^1^5^7");

		assertNoProblems("_var^1^5^7");
		assertNoProblems("_var^_var^5^7");
		assertNoProblems("_var^1^5^_var");
		assertNoProblems("1^1^_var^7");
		assertNoProblems("_var^_var^_var^_var");
	}

	public void testExponentExpression_bad() throws Exception {
		assertHasProblems("1^1^''");
		assertHasProblems("''^1^5");
		assertHasProblems("''^1^5^''");

		assertHasProblems("_var^''^5^7");
		assertHasProblems("''^_var^5^7");
		assertHasProblems("_var^1^''^_var");
		assertHasProblems("''^''");
	}
	//----END exponent Expression----

	//----START signed Expression----
	public void testSignExpression_valid() throws Exception {
		assertNoProblems("+1");
		assertNoProblems("+1.5");
		assertNoProblems("+1e1");
		assertNoProblems("+[]");
		assertNoProblems("+_var");

		assertNoProblems("-1");
		assertNoProblems("-1.5");
		assertNoProblems("-1e1");
		assertNoProblems("-_var");
	}

	public void testSignExpression_bad() throws Exception {
		assertHasProblems("+configFile");
		assertHasProblems("+''");

		assertHasProblems("-[]");
		assertHasProblems("-''");
	}
	//----END signed Expression----

	//----START code block Expression----
	public void testCodeBlockExpression() throws Exception {
		assertNoProblems("{1}");
		assertNoProblems("{+1.5}");
		assertNoProblems("{}");

		assertEquals(ValueType.BaseType.CODE, getExitTypeForText("{}"));
		assertEquals(BaseType.CODE, getExitTypeForText("{1}"));
		assertEquals(ValueType.BaseType.CODE, getExitTypeForText("{_var}"));
		assertEquals(BaseType.CODE, getExitTypeForText("{1+1;1}"));
	}
	//----END code block Expression----

	//----START case statement----
	public void testCaseStatement() throws Exception {
		assertNoProblems("case 1;");
		assertNoProblems("case 2:{};");
		assertNoProblems("case '';");
		assertNoProblems("case [];");
		assertNoProblems("case []:{};");
		assertNoProblems("case []:{1};");

		assertNoProblems("case configFile;");

		assertNoProblems("case _var:{};");
		assertNoProblems("case _var;");

		assertEquals(BaseType.NOTHING, getExitTypeForText("case 1:{};"));
		assertEquals(BaseType.NOTHING, getExitTypeForText("case 1:{2};"));
		assertEquals(BaseType.NOTHING, getExitTypeForText("case 1;"));
		assertEquals(ValueType.BaseType.NOTHING, getExitTypeForText("case configFile;"));
	}
	//----END case statement----

	//----START assignment statement----
	public void testAssignmentStatement() throws Exception {
		assertNoProblems("a = {};");
		assertNoProblems("a={2};");
		assertNoProblems("a = 1+1;");

		assertNoProblems("_var = configFile;");
		assertNoProblems("_var = _var;");

		//this problem should be a grammar error, not a type error
		assertNoProblems("a = ;");

		assertEquals(ValueType.BaseType.NOTHING, getExitTypeForText("a = {};"));
		assertEquals(ValueType.BaseType.NOTHING, getExitTypeForText("a={2};"));
		assertEquals(ValueType.BaseType.NOTHING, getExitTypeForText("a = 1+1;"));
		assertEquals(ValueType.BaseType.NOTHING, getExitTypeForText("a = _var;"));
	}
	//----END assignment statement----

	//----START quest statement----
	public void testQuestStatement_valid() throws Exception {
		assertNoProblems("? true : false;");
		assertNoProblems("? true : {};");
		assertNoProblems("? _var : 1+1;");

		//this problem should be a grammar error, not a type error
		assertNoProblems("? ;");

		assertEquals(BaseType.NOTHING, getExitTypeForText("? true : false;"));
		assertEquals(BaseType.NOTHING, getExitTypeForText("? ;"));
	}

	public void testQuestStatement_bad() throws Exception {
		assertHasProblems("? 1 : false;");
		assertHasProblems("? {} : false;");
	}
	//----END quest statement----

	//----START command expression----
	public void testCommandExpression_randomExpressions_valid() throws Exception {
		assertNoProblems("_ctrl ctrlSetStructuredText parseText localize \"str_vsm_no_vehicle\";");
		assertNoProblems("_ctrl ctrlSetStructuredText parseText '';");
		assertNoProblems("parseText localize \"str_vsm_no_vehicle\";");
		assertNoProblems("if(count _numArr == 0) exitWith{};");
		assertNoProblems("if((_i + 1) >= count _numArr || (_i + 1) >= count _opNumArr) exitWith{};");
		assertNoProblems("if(_numArr select _i > _opNumArr select _i) then {};");
		assertNoProblems("_numArr select _i == _opNumArr select _i");
		assertNoProblems("[_mhq, [_deployLabel, { [_this select 0] call MHQ_fnc_mhqDeployAction; }, [], 6, false, false, \"\", \"(speed (vehicle _target)) < 1 && (getPosATL _target) select 2 < 2\"]] remoteExec [\"addAction\", 0, true]");
		assertNoProblems("for \"_i\" from 0 to 1 do {};");
		assertNoProblems("for \"_i\" from 0 to 1 step -1 do {};");
	}

	public void testCommandExpression_randomExpressions_bad() throws Exception {
		assertHasProblems("createVehicle");
	}

	public void testCommandExpression_ifThen_valid() throws Exception {
		assertExitTypeAndNoProblems("if true then {};", null, BaseType.IF);
		assertExitTypeAndNoProblems("if true then {} else {};", null, ValueType.BaseType.IF);
		assertExitTypeAndNoProblems("if true then [{},{}];", null, ValueType.BaseType.IF);
		assertExitTypeAndNoProblems("if true then [{},{},{}];", null, ValueType.BaseType.IF);
	}

	public void testCommandExpression_ifThen_bad() throws Exception {
		assertHasProblems("if 1 then {};");
		assertHasProblems("if true then {} else;");
		assertHasProblems("if true then [{}];");
		assertHasProblems("if true then [];");
		assertHasProblems("if true then [{},1];");
		assertHasProblems("if true then [1,1];");
		assertHasProblems("if then {};");
		assertHasProblems("if true then;");
	}

	public void testCommandExpression_noArgsCommands_bad() throws Exception {
		assertHasProblems("true true;"); //need semicolon
		assertHasProblems("true 1;"); //need semicolon

	}

	public void testCommandExpression_optionalParameters() throws Exception {
		//fake a command syntax to assert that the syntax xml isn't the creating false positives/negatives
		CommandDescriptor d1 = new CommandDescriptor("getPos", Arrays.asList(
				new CommandSyntax(
						null,
						new ArrayParam(
								false,
								Arrays.asList(
										new Param("required", BaseType.NUMBER, "", false),
										new Param("optional", ValueType.BaseType.NUMBER, "", true)
								),
								true
						),
						new ReturnValueHolder(BaseType.VOID, "")
				)
		), "", BIGame.UNKNOWN);

		CommandDescriptor d2 = new CommandDescriptor("position", Arrays.asList(
				new CommandSyntax(
						new Param("optionalPrefix", BaseType.NUMBER, "", true),
						new ArrayParam(
								false,
								Arrays.asList(
										new ArrayParam(
												false,
												Arrays.asList(
														new Param("required", ValueType.BaseType.CODE, "", false)
												),
												true
										),
										new Param("optional", ValueType.BaseType.NUMBER, "", true)
								),
								true
						),
						new ReturnValueHolder(BaseType.CONFIG, "")
				)
		), "", BIGame.UNKNOWN);


		CommandDescriptorCluster cluster = new CommandDescriptorCluster(d1, d2);

		assertExitTypeAndNoProblems("getPos [1,1];", cluster, ValueType.BaseType.VOID);
		assertExitTypeAndNoProblems("getPos [1];", cluster, ValueType.BaseType.VOID);
		assertExitTypeAndNoProblems("getPos;", cluster, ValueType.BaseType.VOID);
		assertHasProblems("1 getPos"); //can't have prefix

		assertExitTypeAndNoProblems("position [[{}],1];", cluster, ValueType.BaseType.CONFIG);
		assertExitTypeAndNoProblems("position [[{}]];", cluster, BaseType.CONFIG);
		assertExitTypeAndNoProblems("position [];", cluster, ValueType.BaseType.CONFIG);

		assertExitTypeAndNoProblems("0 position;", cluster, BaseType.CONFIG);
		assertExitTypeAndNoProblems("0 position [[{}],1];", cluster, ValueType.BaseType.CONFIG);
		assertExitTypeAndNoProblems("0 position [[{}]];", cluster, BaseType.CONFIG);
		assertExitTypeAndNoProblems("0 position [];", cluster, BaseType.CONFIG);
		assertExitTypeAndNoProblems("0 position;", cluster, BaseType.CONFIG);

		assertExitTypeAndNoProblems("position;", cluster, ValueType.BaseType.CONFIG);

	}
	//----END command expression----
}
