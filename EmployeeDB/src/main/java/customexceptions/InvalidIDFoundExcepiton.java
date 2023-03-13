package customexceptions;

public class InvalidIDFoundExcepiton extends RuntimeException {
	private String message;
	
	public InvalidIDFoundExcepiton(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
