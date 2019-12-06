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
 * Change the Y-coordinate of the turtle. 
 * @author Paul Yang
 *
 */
public class SetyFunction extends AbstractFunction {
	
	private SetyFunction () { }
	
	private static SetyFunction theInstance = new SetyFunction();
	
	public static SetyFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble vy = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		double y = vy.getNumericalValue().doubleValue();
		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		if (tur.isDown())
			ctx.getScreen().drawLine(
					tur.getX(), 
					tur.getY(), 
					tur.getX(),
					y);
		tur.setY(y);

		return vy;
	}
}