package ctlogo.execute.expression;

import ctlogo.data.CTValue;
import ctlogo.exception.*;
import ctlogo.execute.Context;

/**
 * 
 * @author Paul Yang
 * 
 * An OperatorExpreesion object shall have two constructors, one takes a 
 * <code>List<Expression></code> as input, and the other one takes n 
 * Expression.
 *
 */
public interface Expression {
	public CTValue execute(Context context) 
			throws CTDataUndefinedException, CTConversionNotSupportedException;;
}
