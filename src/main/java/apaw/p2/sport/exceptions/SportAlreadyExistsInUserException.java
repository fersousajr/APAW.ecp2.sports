package apaw.p2.sport.exceptions;

public class SportAlreadyExistsInUserException extends Exception{
    private static final long serialVersionUID = 5987911346L;

    public static final String DESC = "Sport already exists in User.";
    
    public SportAlreadyExistsInUserException(String message) {
        super(DESC + " " + message);
    }

    public SportAlreadyExistsInUserException() {
        this("");
    }
}
