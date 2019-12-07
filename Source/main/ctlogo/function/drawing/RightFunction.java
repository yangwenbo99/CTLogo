package ctlogo.function.drawing;

import java.util.ArrayList;
import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.NegativeOperator;
import ctlogo.function.AbstractFunction;
import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

/**
 * Let the turtle turn right.
 * @author Paul Yang
 *
 */
public class RightFunction extends AbstractFunction {
	
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
	protected CTValue execute(Context ctx, List<Expression> params) throws CTException {
		List<Expression> newParams = new ArrayList<>();
		newParams.add(new NegativeOperator(params.get(0)));
		
		Turtle tur = TurtleManager.getInstance().getActiveTurtle();
		if (tur.isDown())
			ctx.getScreen().draw();

		return LeftFunction.getInstance().execute(ctx, newParams);
	}
}
