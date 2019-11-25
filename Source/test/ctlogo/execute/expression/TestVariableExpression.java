/**
 * 
 */
package ctlogo.execute.expression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import ctlogo.data.CTValue;
import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.GlobalContext;
import ctlogo.graphic.Screen;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Paul Yang
 *
 */
public class TestVariableExpression {
	
	private static class StubContext implements Context {

		@Override
		public Scanner getInputScanner() {
			// TODO Auto-generated method stub
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
