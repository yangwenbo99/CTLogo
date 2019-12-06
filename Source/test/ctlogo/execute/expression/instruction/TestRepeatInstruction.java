package ctlogo.execute.expression.instruction;

import static ctlogo.data.TestDataUtility.cint;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.execute.BasicExpressionStream;
import ctlogo.execute.GlobalContext;
import ctlogo.execute.StubScreen;
import ctlogo.execute.expression.Expression;
import ctlogo.graphic.Screen;
import ctlogo.processing.BasicTokenStream;

/**
 * Test the RepeatInstruction class.
 *
 * Since the class is added after <code>{@code BasicExpressionStream}</code> and <code>{@code BasicTokenStream}</code>,
 * it is tested using Top-down method. 
 */
public class TestRepeatInstruction {

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
	void test1() throws IOException, CTException {
		try (BasicTokenStream ts = ts(
				"MAKE \"A 1 REPEAT 5 [MAKE \"A :A + 1]\n")) {
			BasicExpressionStream es = new BasicExpressionStream(ts);
			Expression exp1 = es.getNextExpression();
			exp1.execute(gbl);
			Assertions.assertEquals(cint(1), vm.getValue("A"));
			Expression exp2 = es.getNextExpression();
			exp2.execute(gbl);
			Assertions.assertEquals(cint(6), vm.getValue("A"));
		}

	}

}
