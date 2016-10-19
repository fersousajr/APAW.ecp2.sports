package apaw.p2.sport.exceptions;

public class InvalidUserEmailException extends Exception{
    private static final long serialVersionUID = 15546978997L;

    public static final String DESC = "User email cannot be null.";
    
    public InvalidUserEmailException(String message) {
        super(DESC + " " + message);
    }

    public InvalidUserEmailException() {
        this("");
    }
}
