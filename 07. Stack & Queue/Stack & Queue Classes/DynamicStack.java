package stack;

public class DynamicStack extends CustomStack {
	private static final int DEFAULT_CAPACITY = 10;

	public DynamicStack() {
		super(DEFAULT_CAPACITY);
	}

	public DynamicStack(int cap) {
		super(cap);
	}

	@Override
	public void push(int val) throws StackOverflowException {
		int top = getTop();
		int cap = getCap();
		if (top == cap - 1) {
			int[] newData = new int[2 * cap];
			for (int i = 0; i < cap; i++) {
				newData[i] = data[i];
			}
			setData(newData);

		}
		super.push(val);
	}

}
