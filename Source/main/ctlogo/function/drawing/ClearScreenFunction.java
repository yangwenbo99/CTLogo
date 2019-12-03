package ctlogo.function.drawing;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;
import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

/**
 * Clean the screen, reseting the orientation and position of turtle
 * @author Paul Yang
 *
 */
public class ClearScreenFunction extends AbstractFunction {
	
	private ClearScreenFunction () { }
	
	private static ClearScreenFunction theInstance = new ClearScreenFunction();
	
	public static ClearScreenFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 0;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		ctx.getScreen().clean();
		TurtleManager.getInstance().getActiveTurtle().setOrientation(Math.PI / 2);
		TurtleManager.getInstance().getActiveTurtle().setX(0);
		TurtleManager.getInstance().getActiveTurtle().setY(0);

		return CTUndefined.UNDEFINED;
	}
}