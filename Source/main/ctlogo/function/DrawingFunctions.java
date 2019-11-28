package ctlogo.function;

import java.util.ArrayList;
import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.NegativeOperator;
import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

class ForwardFunction extends AbstractFunction {
	
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
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
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

class BackwardFunction extends AbstractFunction {
	
	private BackwardFunction () { }
	
	private static BackwardFunction theInstance = new BackwardFunction();
	
	public static BackwardFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		List<Expression> newParams = new ArrayList<>();
		newParams.add(new NegativeOperator(params.get(0)));
		return ForwardFunction.getInstance().execute(ctx, newParams);
	}
}


class LeftFunction extends AbstractFunction {
	
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
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		CTDouble v = (CTDouble) 
				params.get(0).execute(ctx).convertTo(CTDouble.getTypeMarkerStatic());
		double sa= (v.getNumericalValue().doubleValue() % 360) * Math.PI / 180;

		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		tur.offsetOrientation(sa);

		return v;
	}
}

class RightFunction extends AbstractFunction {
	
	private RightFunction () { }
	
	private static RightFunction theInstance = new RightFunction();
	
	public static RightFunction getInstance() {
		return theInstance;
	}

	@Override
	public int getDefaultParameterNum() {
		return 1;
	}

	@Override
	CTValue execute(Context ctx, List<Expression> params) throws CTException {
		List<Expression> newParams = new ArrayList<>();
		newParams.add(new NegativeOperator(params.get(0)));
		return LeftFunction.getInstance().execute(ctx, newParams);
	}
}