package ctlogo.exception;

public class CTException extends Exception {
    private static final long serialVersionUID = 8017137499585666044L;

    public CTException(String message) {
        super(message);
    }

    public CTException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
