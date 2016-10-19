package apaw.p2.sport.exceptions;

public class RequestNotHandledException extends Exception{
	private static final long serialVersionUID = 12456657L;

    public static final String DESC = "Request not handled.";

    public RequestNotHandledException(String message) {
        super(DESC + " " + message);
    }

    public RequestNotHandledException() {
        this("");
    }
}
