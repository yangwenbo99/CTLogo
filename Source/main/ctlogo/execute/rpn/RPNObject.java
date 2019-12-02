/**
 * 
 */
package ctlogo.execute.rpn;

/**
 * @author Paul Yang
 *
 * An RPNObject is either an RPNEvaluable or an RPNOperable, and
 * occationally, both. An RPNObject may also be an terminator, mainly for 
 * terminating variable sized argument list.
 *
 */
public interface RPNObject {
    boolean isEvaluable();
    boolean isOperable();
    boolean isTerminator();
}
