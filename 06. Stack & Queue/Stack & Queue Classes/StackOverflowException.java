package stack;

public class StackOverflowException extends Exception{
	public StackOverflowException() {
		super("Stack Overflow occurred");
	}
	
	public StackOverflowException(String error) {
		super(error);
	}

}
