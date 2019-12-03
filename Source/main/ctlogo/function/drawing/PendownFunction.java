package ctlogo.function.drawing;

import java.util.ArrayList;
import java.util.List;

import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.NegativeOperator;
import ctlogo.function.AbstractFunction;
import ctlogo.turtle.TurtleManager;

/**
 * Put pen down (so that the turtle draws shapes).
 * @author Paul Yang
 *
 */
public class PendownFunction extends AbstractFunction {
	
	private PendownFunction () { }
	
	private static PendownFunction theInstance = new PendownFunction();
	
	public static PendownFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		TurtleManager.getInstance().getActiveTurtle().setDown(true);
		return CTUndefined.UNDEFINED;
	}
}
