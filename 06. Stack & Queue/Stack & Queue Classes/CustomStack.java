package stack;

public class CustomStack implements IStack {
	protected int[] data;
	protected int top; // index of top element
	protected int cap; // capacity of stack, can be provided at runtime else defaults to 10
	private static final int DEFAULT_CAPACITY = 10;

	protected CustomStack(int cap) {
		this.data = new int[cap];
		this.top = -1;
		this.cap = cap;
	}

	protected CustomStack() {
		this(DEFAULT_CAPACITY);

	}

	protected int[] getData() {
		return data;
	}

	protected int getData(int index) {
		return data[index];
	}

	protected void setData(int[] data) {
		this.data = data;
		this.cap = data.length;
	}

	protected void setData(int index, int val) {
		data[index] = val;
	}

	protected int getTop() {
		return top;
	}

	protected void setTop(int top) {
		this.top = top;
	}


	protected int getCap() {
		return cap;
	}
	
	private int getSize() {
		return top + 1;
	}

	public int size() {
		return getSize();
	}

	public void display() {

		for (int j = top; j >= 0; j--) {
			System.out.print(data[j] + " ");
		}
		System.out.println();
	}

	public void push(int val) throws StackOverflowException {

		if (top == data.length - 1) {
			throw new StackOverflowException();
		} else {
			top++;
			data[top] = val;
		}
	}

	public int pop() throws StackUnderflowException {

		if (top == -1) {
			throw new StackUnderflowException();
		} else {
			top--;
			return data[top + 1];
		}
	}

	public int peek() throws StackUnderflowException {

		if (top == -1) {
			throw new StackUnderflowException();
		}
		return data[top];
	}

}
