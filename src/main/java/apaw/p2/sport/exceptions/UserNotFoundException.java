package apaw.p2.sport.exceptions;

public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 199999156464L;
	
	private static final String DESC = "User not found.";
	
	public UserNotFoundException(String message){
		super(DESC + " " + message);
	}
	
	public UserNotFoundException(){
		this("");
	}

}
