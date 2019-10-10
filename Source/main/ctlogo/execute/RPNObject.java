/**
 * 
 */
package ctlogo.execute;

/**
 * @author Paul Yang
 *
 * <remark>An RPNObject is either an RPNEvaluable or an RPNOperable, and
 * occationally, both. An RPNObject may also be an terminator, mainly for 
 * terminating variable sized argument list.</remark>
 *
 */
interface RPNObject {
    boolean isEvaluable();
    boolean isOperable();
    boolean isTerminator();
}
