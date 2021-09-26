package stack;

public interface IStack {
	public void push(int val) throws StackOverflowException;
	public int pop() throws StackUnderflowException;
	public int peek() throws StackUnderflowException;
	public int size();
	public void display();
}
