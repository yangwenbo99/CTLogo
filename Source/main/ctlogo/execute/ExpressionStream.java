package ctlogo.execute;

import java.util.List;

public interface ExpressionStream {
	public Expression getNextExpression();// Evaluate [ ] to value list, {} to block

	public List<Expression> geNextBlock();// for {} and []

	public Expression getNextString(); // variable, literal or function result, [] to string
}
