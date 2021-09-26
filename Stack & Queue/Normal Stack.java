public static class CustomStack {
    int[] data;
    int top;

    public CustomStack(int maxSize) {
      data = new int[maxSize];
      top = -1;
    }

    int size() {
      return top + 1;  
    }

    void display() {
      // write ur code here
      for(int i=top; i>=0; i--){
          System.out.print(data[i] + " ");
      }
      System.out.println();
    }

    void push(int val) {
      if(top == data.length - 1){
        System.out.println("Stack overflow");
        return;
      }
      
      top++;
      data[top] = val;
    }

    int pop() {
        if(top == -1){
            System.out.println("Stack underflow");
            return -1;
        }
        
        int topEle = data[top];
        top--;
        return topEle;
    }

    int top() {
        if(top == -1){
            System.out.println("Stack underflow");
            return -1;
        }
        
        return data[top];
    }
  }
