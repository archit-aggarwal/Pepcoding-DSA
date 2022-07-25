package stack;

public class Client {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		
		IStack normalStack = new CustomStack(3);
		
		normalStack.push(10);
		normalStack.push(20);
		normalStack.push(30);
//		normalStack.push(50); -> Uncomment to see StackOverFlowException
		System.out.println(normalStack.peek());
		System.out.println(normalStack.pop());
		System.out.println(normalStack.pop());
		System.out.println("Size: " +normalStack.size());
		normalStack.push(40);
		normalStack.push(50);
		System.out.println(normalStack.peek());
		System.out.println(normalStack.size());
		normalStack.display();
		System.out.println(normalStack.pop());
		System.out.println(normalStack.pop());
		System.out.println(normalStack.pop());
		System.out.println("Size: " + normalStack.size());
		
		//System.out.println(normalStack.pop()); 
		// Uncomment Line 26 to see StackUnderflow because size=0 when we're trying to pop
	
		IStack dStack = new DynamicStack(3); //dStack denotes dynamic stack
		dStack.push(10);
		dStack.push(20);
		dStack.push(30);
		dStack.push(10);
		dStack.push(20);
		dStack.push(30);
		//System.out.println(dStack.size());
		dStack.push(40);
		dStack.push(50);
		dStack.push(60);
		dStack.push(50);
		dStack.push(60);
		dStack.display();
		System.out.println("Size: "+dStack.size());
		System.out.println(dStack.pop());
		System.out.println(dStack.pop());
	}

}
