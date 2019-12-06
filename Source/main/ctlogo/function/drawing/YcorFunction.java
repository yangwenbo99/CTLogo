package ctlogo.function.drawing;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;
import ctlogo.turtle.TurtleManager;

/**
 * Query the Y-coordinate of the turtle. 
 * @author Paul Yang
 *
 */
public class YcorFunction extends AbstractFunction {
	
	private YcorFunction () { }
	
	private static YcorFunction theInstance = new YcorFunction();
	
	public static YcorFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		double y = TurtleManager.getInstance().getActiveTurtle().getY();
		return new CTDouble(y);
	}
}