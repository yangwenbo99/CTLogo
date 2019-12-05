/**
 * 
 */
package ctlogo.execute.expression;

import static ctlogo.data.TestDataUtility.cint;

import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.graphic.Screen;

/**
 * @author Paul Yang
 *
 */
public class TestVariableExpression {
	
	private static class StubContext implements Context {

		@Override
		public Scanner getInputScanner() {
			return null;
		}

		@Override
		public PrintStream getOutputStream() {
			return null;
		}

		@Override
		public Screen getScreen() {
			return null;
		}

		@Override
		public VariableManager getVariableManager() {
			return null;
		}

		@Override
		public CTValue getValueOf(String vname) {
			if (vname.toLowerCase().equals("test"))
				return cint(1);
			else
				return null;
		}
	}
	
	@Test
	void test1() throws CTException {
		VariableExpression ve = new VariableExpression("Test");
		Context ctx = new StubContext();
		Assertions.assertEquals(cint(1), ve.execute(ctx));
	}

}
