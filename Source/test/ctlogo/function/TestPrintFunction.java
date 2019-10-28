package ctlogo.function;

import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.*;

import ctlogo.data.CTInteger;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.AbstractContext;
import ctlogo.execute.Context;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;
import ctlogo.graphic.Screen;

import static ctlogo.data.TestDataUtility.*;

public class TestPrintFunction {
	
	static class StubContext extends AbstractContext {
		public StubContext(
				Scanner scanner, 
				PrintStream outputStream, 
				Screen screen, 
				VariableManager variableManager) {
			super(scanner, outputStream, screen, variableManager);
		}
	}
	
	// private static Context stubContext = new StubContext(null, , screen, variableManager)
	
	@Test
	void test1() {
		
	}
	
}