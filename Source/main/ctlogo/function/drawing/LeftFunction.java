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

public class LeftFunction extends AbstractFunction {
	
	private LeftFunction () { }
	
	private static LeftFunction theInstance = new LeftFunction();
	
	public static LeftFunction getInstance() {
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
		double sa= (v.getNumericalValue().doubleValue() % 360) * Math.PI / 180;

		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		tur.offsetOrientation(sa);

		return v;
	}
}
