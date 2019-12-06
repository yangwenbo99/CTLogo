/**
 * 
 */
package ctlogo.execute;

import static ctlogo.data.TestDataUtility.cint;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;
import ctlogo.function.BasicFunctionExpression;
import ctlogo.graphic.Screen;
import ctlogo.processing.BasicTokenStream;

import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

/**
 * @author Paul Yang
 *
 */
public class TestBasicExpressionHelper {

	@Test
	void testIsLiteral() {
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("\"A"));
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("0x1"));
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("1.1"));
		Assertions.assertFalse(BasicExpressionHelper.isLiteral("asdf"));
	}

	@Test
	void testIsStringLiteral() {
		Assertions.assertFalse(BasicExpressionHelper.isLiteral("as"));
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("'A'"));
		Assertions.assertFalse(BasicExpressionHelper.isLiteral("'A"));
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("\"A"));
		Assertions.assertFalse(BasicExpressionHelper.isLiteral("\""));
	}

	@Test
	void testIsDoubleLiteral() {
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("1.0"));
		Assertions.assertFalse(BasicExpressionHelper.isLiteral("A'"));
	}

	@Test
	void testIsIntegerLiteral() {
		Assertions.assertTrue(BasicExpressionHelper.isLiteral("0x1"));
		Assertions.assertFalse(BasicExpressionHelper.isLiteral("A'"));
	}

	@Test
	void testParseLiteral() throws CTException {
		// String
		Assertions.assertEquals(
				cstr("A"), 
				BasicExpressionHelper.parseLiteral("'A'").execute(null));
		Assertions.assertEquals(
				cstr("A"), 
				BasicExpressionHelper.parseLiteral("\"A").execute(null));
		// Int
		Assertions.assertEquals(
				cint(1),
				BasicExpressionHelper.parseLiteral("0x1").execute(null));
		// Double
		Assertions.assertEquals(
				cdbl(1.5),
				BasicExpressionHelper.parseLiteral("1.5").execute(null));
		// Exception
		Assertions.assertThrows(
				NumberFormatException.class,
				() -> BasicExpressionHelper.parseLiteral("asd"));
	}
}
