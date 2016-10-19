package apaw.p2.sport.exceptions;

public class SportAlreadyExistsException extends Exception{
    private static final long serialVersionUID = 354781223L;

    public static final String DESC = "Sport already exists.";
    
    public SportAlreadyExistsException(String message) {
        super(DESC + " " + message);
    }

    public SportAlreadyExistsException() {
        this("");
    }
}
