package apaw.p2.sport.exceptions;

public class SportNotFoundException extends Exception{
	private static final long serialVersionUID = 11111987894L;
	
	private static final String DESC = "Sport not found.";
	
	public SportNotFoundException(String message){
		super(DESC + " " + message);
	}
	
	public SportNotFoundException(){
		this("");
	}
}
