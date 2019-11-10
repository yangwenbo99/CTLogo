/**
 * 
 */
package ctlogo.execute.rpn;

/**
 * @author Paul Yang
 *
 */
public class RPNTerminator implements RPNObject {
    private static RPNTerminator theInstance = new RPNTerminator();

    private RPNTerminator() { }

	@Override
	public boolean isEvaluable() {
		return false;
	}

	@Override
	public boolean isOperable() {
		return false;
	}

	@Override
	public boolean isTerminator() {
		return true;
	}

    public static RPNTerminator getInstance() { return theInstance; }

}
