/**
 * 
 */
package ctlogo.function;

import static ctlogo.data.TestDataUtility.cint;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.data.GlobalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTException;
import ctlogo.execute.AbstractContext;
import ctlogo.execute.Context;
import ctlogo.execute.StubScreen;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;
import ctlogo.graphic.Screen;
import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

/**
 * @author Paul Yang
 *
 */
public class TestDrawingFunctions {
    private final Scanner sc = new Scanner("Test scanner");
    private final PrintStream os = System.out;
    private final VariableManager vm = new GlobalVariableManager();
    private final Screen sn = StubScreen.theInstance;
    private Context stubContext = new StubContext(sc, os, sn, vm);
    
    class StubContext extends AbstractContext {
        public StubContext(
                Scanner scanner, 
                PrintStream outputStream, 
                Screen screen, 
                VariableManager variableManager) {
            super(scanner, outputStream, screen, variableManager);
        }
    }

	private static LiteralExpression l(CTValue v) {
		return new LiteralExpression(v);
	}
	
	private Turtle turtle() {
		return TurtleManager.getInstance().getActiveTurtle();
	}
	
	@BeforeEach
	private void initTests() {
		turtle().setX(0);
		turtle().setY(0);
		turtle().setOrientation(0);
	}

	@Test
	void testForward() throws CTException {
		Assertions.assertEquals(1, ForwardFunction.getInstance().getDefaultParameterNum());
		ForwardFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100)))
				);
		Assertions.assertEquals(
				100.0,
				turtle().getX()
				);
	}

	@Test
	void testBackward() throws CTException {
		Assertions.assertEquals(1, BackwardFunction.getInstance().getDefaultParameterNum());
		BackwardFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100)))
				);
		Assertions.assertEquals(
				-100.0,
				turtle().getX()
				);
	}

	@Test
	void testLeft() throws CTException {
		Assertions.assertEquals(1, LeftFunction.getInstance().getDefaultParameterNum());
		LeftFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(90))));
		Assertions.assertEquals(
				Math.PI / 2,
				turtle().getOrientation(),
				1e-7);
		ForwardFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100))));
		Assertions.assertEquals(
				0.0,
				turtle().getX(),
				1e-7);
		Assertions.assertEquals(
				100.0,
				turtle().getY(),
				1e-7);
	}

	@Test
	void testRight() throws CTException {
		Assertions.assertEquals(1, RightFunction.getInstance().getDefaultParameterNum());
		RightFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(90))));
		Assertions.assertEquals(
				- Math.PI / 2,
				turtle().getOrientation(),
				1e-7);
		ForwardFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100))));
		Assertions.assertEquals(
				0.0,
				turtle().getX(),
				1e-7);
		Assertions.assertEquals(
				-100.0,
				turtle().getY(),
				1e-7);
	}
}
