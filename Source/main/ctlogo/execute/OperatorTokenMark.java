package ctlogo.execute;

import ctlogo.execute.rpn.RPNOperable;

class OperatorTokenMark {
    private RPNOperable rpnOperable;
    private int precedence;
    private boolean isLeftParenthesis;

    /**
     * @param rpnOperable
     * @param priority
     */
    public OperatorTokenMark(RPNOperable rpnOperable, int priority) {
        this.rpnOperable = rpnOperable;
        this.precedence = priority;
        this.isLeftParenthesis = false;
    }

    /**
     * Construct a marker for "(".
     *
     * @param isLeftParenthesis
     *
     * Always has lowest precedence. Why? Because this is good for 
     * implementation.
     */
    private OperatorTokenMark() {
        this.rpnOperable = null;
        this.precedence = Integer.MIN_VALUE;
        this.isLeftParenthesis = true;
    }

    private static OperatorTokenMark forLeftParenthesis = new OperatorTokenMark();

    public static OperatorTokenMark forLeftParenthesis() {
        return forLeftParenthesis;
    }

    /**
     * @return the rpnOperable
     */
    public RPNOperable getRpnOperable() {
        return rpnOperable;
    }

    /**
     * @return the priority
     */
    public int getPrecedence() {
        return precedence;
    }

    public boolean isLeftParenthesis() {
        return isLeftParenthesis;
    }

}
