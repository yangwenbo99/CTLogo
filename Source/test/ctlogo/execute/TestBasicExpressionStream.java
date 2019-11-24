/**
 * 
 */
package ctlogo.execute;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.processing.BasicTokenStream;
import ctlogo.processing.TokenStream;
import ctlogo.execute.expression.Expression;
import ctlogo.function.BasicFunctionExpression;
import ctlogo.graphic.Screen;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

/**
 * @author Paul Yang
 *
 */
public class TestBasicExpressionStream {

	private final Scanner sc = new Scanner("Test scanner");
	private final PrintStream os = System.out;
	private final VariableManager vm = new GlobalVariableManager();
	private final Screen sn = StubScreen.theInstance;
	private final GlobalContext gbl = new GlobalContext(
			sc, 
			os,
			sn,
			vm);

	private BasicTokenStream ts(String s) {
		return new BasicTokenStream(new Scanner(s));
	}

	@Test
	void testBasics() throws IOException, CTException {
		try (BasicTokenStream ts = ts("1 1+-1\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			// literal 
			Expression exp1 = es.getNextExpression();
			Assertions.assertEquals(cint(1), exp1.execute(gbl));

			// binary + unary
			Expression exp2 = es.getNextExpression();
			Assertions.assertEquals(cint(0), exp2.execute(gbl));
		}

		// Exception when oeprators of incorrect form 
		try (BasicTokenStream ts = ts("*1\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Assertions.assertThrows(
					CTSyntaxException.class,
					() -> es.getNextExpression());
		}
	}
	
	@Test
	void testMultipleOperations() throws IOException, CTException {
		try (BasicTokenStream ts = ts("1+-1+1\n 1 + 2 * 3\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp1 = es.getNextExpression();
			Assertions.assertEquals(cint(1), exp1.execute(gbl));

			Expression exp2 = es.getNextExpression();
			Assertions.assertEquals(cint(7), exp2.execute(gbl));
		}
	}

	@Test
	void testParenthises() throws IOException, CTException {
		try (BasicTokenStream ts = ts("(1 + 2) * 3\n(1 + 2 *(3 + 4)) + 5\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp1 = es.getNextExpression();
			Assertions.assertEquals(cint(9), exp1.execute(gbl));
			Expression exp2 = es.getNextExpression();
			Assertions.assertEquals(cint(20), exp2.execute(gbl));
		}
	}

	@Test
	void testFunction() throws IOException, CTException {
		try (BasicTokenStream ts = ts("PR 1\n (PR 2 3 4)\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp1 = es.getNextExpression();
			Assertions.assertEquals(
					BasicFunctionExpression.class,
					exp1.getClass());
			Expression exp2 = es.getNextExpression();
			Assertions.assertEquals(
					BasicFunctionExpression.class,
					exp2.getClass());
		}
	}

	@Test
	void testVariable() throws IOException, CTException {
		// using controled structure
		try (BasicTokenStream ts = ts(":testv\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp = es.getNextExpression();
			vm.setLocalVariable("testv", cint(10));
			Assertions.assertEquals(cint(10), exp.execute(gbl));
		}

		try (BasicTokenStream ts = ts("PR :testv MAKE \"testv 1 PR :testv\n:testv\n")) {
			// BasicExpressionStream es = new BasicExpressionStream(ts);
			// es.getNextExpression();
			// es.getNextExpression();
			// es.getNextExpression();
			// es.getNextExpression();
		}

		// using MAKE command 
		try (BasicTokenStream ts = ts("MAKE \"testv 1\n:testv\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp = es.getNextExpression();
			Assertions.assertEquals(cint(1), exp.execute(gbl));
			exp = es.getNextExpression();
			Assertions.assertEquals(cint(1), exp.execute(gbl));
		}
		try (BasicTokenStream ts = ts("MAKE \"testv2 2\n:testv2\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp = es.getNextExpression();
			Assertions.assertEquals(cint(2), exp.execute(gbl));
			exp = es.getNextExpression();
			Assertions.assertEquals(cint(2), exp.execute(gbl));
		}
	}

	@Test
	void testSyntaxException() throws IOException, CTException {
		try (BasicTokenStream ts = ts("(l+ 2) * 3\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Assertions.assertThrows(
					CTSyntaxException.class, 
					() -> es.getNextExpression());
		}
	}

}
