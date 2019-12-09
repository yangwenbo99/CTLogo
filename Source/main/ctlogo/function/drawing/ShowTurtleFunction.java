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
 * Put pen down (so that the turtle draws shapes).
 * @author Paul Yang
 *
 */
public class ShowTurtleFunction extends AbstractFunction {
	
	private ShowTurtleFunction () { }
	
	private static ShowTurtleFunction theInstance = new ShowTurtleFunction();
	
	public static ShowTurtleFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		TurtleManager.getInstance().getActiveTurtle().setVisible(true);
		ctx.getScreen().drawLine(0, 0, 0, 0);
		return CTUndefined.UNDEFINED;
	}
}
