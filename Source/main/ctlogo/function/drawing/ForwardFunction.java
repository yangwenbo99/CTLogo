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

public class ForwardFunction extends AbstractFunction {
	
	private ForwardFunction () { }
	
	private static ForwardFunction theInstance = new ForwardFunction();
	
	public static ForwardFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		double length = v.getNumericalValue().doubleValue();
		double angle = TurtleManager.getInstance().getActiveTurtle().getOrientation();
		double sx = length * Math.cos(angle);
		double sy = length * Math.sin(angle);
		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		if (tur.isDown())
			ctx.getScreen().drawLine(
					tur.getX(), 
					tur.getY(), 
					tur.getX() + sx, 
					tur.getY() + sy);
		tur.shiftXY(sx, sy);

		return v;
	}
}