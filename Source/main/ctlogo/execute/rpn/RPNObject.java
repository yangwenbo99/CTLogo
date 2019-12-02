/**
 * 
 */
package ctlogo.execute.rpn;

/**
 * An object for reverse Polish notation arithmetics. 
 *
 * This interface is used for implementing the {@code BasicExpressionStream}1
 * An RPNObject is either an RPNEvaluable or an RPNOperable, and
 * occationally, both. An RPNObject may also be an terminator, mainly for 
 * terminating variable sized argument list.
 *
 * @author Paul Yang
 *
 */
public interface RPNObject {
	/**
	 * Return whether this object is evaluable.
	 *
	 * @return whether this object is evaluable
	 */
    boolean isEvaluable();

	/**
	 *
	 * Return whether this object is operable.
	 *
	 * @return whether this object is operable
	 */
    boolean isOperable();

	/**
	 * Return whether this object is a terminator.
	 *
	 * @return whether this object is a terminator.
	 */
    boolean isTerminator();
}
