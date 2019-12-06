package ctlogo.function.drawing;

import java.util.List;

import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;
import ctlogo.turtle.TurtleManager;

/**
 * Put pen up (so that the turtle does not draw shapes).
 * @author Paul Yang
 *
 */
public class PenupFunction extends AbstractFunction {
	
	private PenupFunction () { }
	
	private static PenupFunction theInstance = new PenupFunction();
	
	public static PenupFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		TurtleManager.getInstance().getActiveTurtle().setDown(false);
		return CTUndefined.UNDEFINED;
	}
}
