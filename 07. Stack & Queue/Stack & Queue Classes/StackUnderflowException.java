package stack;

public class StackUnderflowException extends Exception{
	
	public StackUnderflowException() {
		super("Stack Underflow occurred");
	}
	
	public StackUnderflowException(String error) {
		super(error);
	}


}
