package apaw.p2.sport.exceptions;

public class InvalidSportNameException extends Exception{
    private static final long serialVersionUID = 2645179652635L;

    public static final String DESC = "Sport name cannot be null.";
    
    public InvalidSportNameException(String message) {
        super(DESC + " " + message);
    }

    public InvalidSportNameException() {
        this("");
    }
}
