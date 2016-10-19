package apaw.p2.sport.exceptions;

public class InvalidUserNickException extends Exception{
    private static final long serialVersionUID = 45647894114L;

    public static final String DESC = "User nickname cannot be null.";
    
    public InvalidUserNickException(String message) {
        super(DESC + " " + message);
    }

    public InvalidUserNickException() {
        this("");
    }
}
