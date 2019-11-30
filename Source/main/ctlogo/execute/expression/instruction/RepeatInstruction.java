/**
 * 
 */
package ctlogo.execute.expression.instruction;

import java.util.List;

import ctlogo.data.CTInteger;
import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.exception.CTSyntaxException;
import ctlogo.exception.CTUnexpectedTokenException;
import ctlogo.execute.Context;
import ctlogo.execute.ExpressionStream;
import ctlogo.execute.expression.Expression;
import ctlogo.processing.TokenStream;

/**
 * @author yang
 *
 */
public class RepeatInstruction implements Instruction {

	private RepeatInstruction() { }

	private static RepeatInstruction instance = new RepeatInstruction();

	public static RepeatInstruction getInstance() {
		return instance;
	}

	@SuppressWarnings("unused")
	private class RepeatExpression implements Expression {
		
		Expression times; 
		private List<Expression> block;

		public RepeatExpression(Expression times, List<Expression> block) {
			this.block = block;
			this.times = times;
		}

		@Override
		public CTValue execute(Context context) throws CTException {
			CTValue timesv = times.execute(context).convertTo(CTInteger.getTypeMarkerStatic());
			long timesl = ((CTInteger) timesv).getNumericalValue().longValue();
			for (long i=0; i<timesl; i++) {
				for (Expression exp : block) {
					exp.execute(context);
				}
			}
			return timesv;
		}
	};

	@Override
	public Expression getExpression(
			TokenStream ts, 
			ExpressionStream es, 
			boolean isFirst) throws CTSyntaxException {
		String name = ts.popNext();
		if (!name.toUpperCase().equals("REPEAT")) {
			throw new CTUnexpectedTokenException("REPEAT", name);
		}
		return new RepeatExpression(es.getNextExpression(), es.geNextBlock());
	}

}
