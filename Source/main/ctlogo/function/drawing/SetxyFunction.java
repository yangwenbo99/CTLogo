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
 * Change the coordination of the turtle. 
 * @author Paul Yang
 *
 */
public class SetxyFunction extends AbstractFunction {
	
	private SetxyFunction () { }
	
	private static SetxyFunction theInstance = new SetxyFunction();
	
	public static SetxyFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 2;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble vx = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		double x = vx.getNumericalValue().doubleValue();
		CTDouble vy = (CTDouble) 
				params.get(1).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		double y = vy.getNumericalValue().doubleValue();
		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		if (tur.isDown())
			ctx.getScreen().drawLine(
					tur.getX(), 
					tur.getY(), 
					x,
					y);
		tur.setX(x);
		tur.setY(y);

		return vy;
	}
}