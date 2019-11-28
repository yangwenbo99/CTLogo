package ctlogo.exception;

public class CTSyntaxException extends CTException {

    /**
     *
     */
    private static final long serialVersionUID = -8911148855580564534L;

    public CTSyntaxException(String message) {
        super(message);
    }

    public CTSyntaxException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
