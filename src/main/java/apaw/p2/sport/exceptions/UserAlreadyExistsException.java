package apaw.p2.sport.exceptions;

public class UserAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 22222987894L;
	
	private static final String DESC = "Sport already exists.";
	
	public UserAlreadyExistsException(String message){
		super(DESC + " " + message);
	}
	
	public UserAlreadyExistsException(){
		this("");
	}
}
