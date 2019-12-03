/**
 * 
 */
package ctlogo.function.drawing;

import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cdbl;

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
import ctlogo.function.drawing.RightFunction;
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
    private final StubScreen sn = new StubScreen();
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
		turtle().setDown(true);
	}

	@Test
	void testForward() throws CTException {
		Assertions.assertEquals(1, ForwardFunction.getInstance().getDefaultParameterNum());
		ForwardFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100)))
				);
		Assertions.assertEquals(100.0, turtle().getX());
		Assertions.assertEquals(1, sn.getNoLine());
	}

	@Test
	void testBackward() throws CTException {
		Assertions.assertEquals(1, BackwardFunction.getInstance().getDefaultParameterNum());
		BackwardFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100)))
				);
		Assertions.assertEquals(-100.0, turtle().getX());
		Assertions.assertEquals(1, sn.getNoLine());
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

	@Test 
	void testSetxy() throws CTException {
		Assertions.assertEquals(2, SetxyFunction.getInstance().getDefaultParameterNum());
		SetxyFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(90)), l(cint(75))));
		Assertions.assertEquals(90, TurtleManager.getInstance().getActiveTurtle().getX());
		Assertions.assertEquals(75, TurtleManager.getInstance().getActiveTurtle().getY());
		Assertions.assertEquals(1, sn.getNoLine());
	}

	@Test 
	void testSetx() throws CTException {
		Assertions.assertEquals(1, SetxFunction.getInstance().getDefaultParameterNum());
		SetxFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(100))));
		Assertions.assertEquals(100, TurtleManager.getInstance().getActiveTurtle().getX());
		Assertions.assertEquals(1, sn.getNoLine());
	}

	@Test 
	void testSety() throws CTException {
		Assertions.assertEquals(1, SetyFunction.getInstance().getDefaultParameterNum());
		SetyFunction.getInstance().execute(
				stubContext, 
				List.<Expression>of(l(cint(10))));
		Assertions.assertEquals(10, TurtleManager.getInstance().getActiveTurtle().getY());
		Assertions.assertEquals(1, sn.getNoLine());
	}

	@Test 
	void testPendown() throws CTException {
		turtle().setDown(false);
		Assertions.assertEquals(0, PendownFunction.getInstance().getDefaultParameterNum());
		PendownFunction.getInstance().execute(stubContext, List.<Expression>of());
		Assertions.assertEquals(true, TurtleManager.getInstance().getActiveTurtle().isDown());
	}

	@Test 
	void testPenup() throws CTException {
		turtle().setDown(true);
		Assertions.assertEquals(0, PenupFunction.getInstance().getDefaultParameterNum());
		PenupFunction.getInstance().execute(stubContext, List.<Expression>of());
		Assertions.assertEquals(false, TurtleManager.getInstance().getActiveTurtle().isDown());
	}

	@Test 
	void testXcor() throws CTException {
		turtle().setX(5);
		Assertions.assertEquals(0, XcorFunction.getInstance().getDefaultParameterNum());
		Assertions.assertEquals(
				cdbl(5.), XcorFunction.getInstance().execute(stubContext, List.<Expression>of()));
	}

	@Test 
	void testYcor() throws CTException {
		turtle().setY(5);
		Assertions.assertEquals(0, YcorFunction.getInstance().getDefaultParameterNum());
		Assertions.assertEquals(
				cdbl(5.), YcorFunction.getInstance().execute(stubContext, List.<Expression>of()));
	}

	@Test
	void testClean() throws CTException {
		Assertions.assertEquals(0, CleanFunction.getInstance().getDefaultParameterNum());
		CleanFunction.getInstance().execute(stubContext, List.<Expression>of());
		Assertions.assertEquals(1, sn.getNoClean());
	}

	@Test
	void testClearScreen() throws CTException {
		Assertions.assertEquals(0, ClearScreenFunction.getInstance().getDefaultParameterNum());
		turtle().setX(2);
		turtle().setY(10);
		ClearScreenFunction.getInstance().execute(stubContext, List.<Expression>of());
		Assertions.assertEquals(1, sn.getNoClean());
		Assertions.assertEquals(0, turtle().getX());
		Assertions.assertEquals(0, turtle().getY());
	}


}
