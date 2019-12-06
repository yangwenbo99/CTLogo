package ctlogo.function.drawing;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.function.AbstractFunction;
import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

/**
 * Change the X-coordinate of the turtle. 
 * @author Paul Yang
 *
 */
public class SetxFunction extends AbstractFunction {
	
	private SetxFunction () { }
	
	private static SetxFunction theInstance = new SetxFunction();
	
	public static SetxFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble vx = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		double x = vx.getNumericalValue().doubleValue();
		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		if (tur.isDown())
			ctx.getScreen().drawLine(
					tur.getX(), 
					tur.getY(), 
					x,
					tur.getY());
		tur.setX(x);

		return vx;
	}
}