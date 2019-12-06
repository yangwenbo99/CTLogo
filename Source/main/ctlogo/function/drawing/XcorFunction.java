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
 * Query the X-coordinate of the turtle. 
 * @author Paul Yang
 *
 */
public class XcorFunction extends AbstractFunction {
	
	private XcorFunction () { }
	
	private static XcorFunction theInstance = new XcorFunction();
	
	public static XcorFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		double x = TurtleManager.getInstance().getActiveTurtle().getX();
		return new CTDouble(x);
	}
}