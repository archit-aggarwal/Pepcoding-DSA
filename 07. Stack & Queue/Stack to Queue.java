// Push Efficient
public static class StackToQueueAdapter {
    Stack<Integer> mainS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
    }

    int size() {
        return mainS.size();
    }

    void add(int val) {
        mainS.push(val);
    }

    int remove() {
        if(mainS.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        
        Stack<Integer> helperS = new Stack<>();
        
        int count = mainS.size() - 1;
        for(int i=1; i<=count; i++){
            helperS.push(mainS.pop());
        }
        
        int val = mainS.pop();
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
        return val;
    }

    int peek() {
        if(mainS.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        
        Stack<Integer> helperS = new Stack<>();
        
        int count = mainS.size() - 1;
        for(int i=1; i<=count; i++){
            helperS.push(mainS.pop());
        }
        
        int val = mainS.peek();
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
        return val;
    }
  }

// Pop Efficient 
public static class StackToQueueAdapter {
    Stack<Integer> mainS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
    }

    int size() {
        return mainS.size();
    }

    void add(int val) {
        Stack<Integer> helperS = new Stack<>();
        while(!mainS.isEmpty()){
            helperS.push(mainS.pop());
        }
        
        mainS.push(val);
        while(!helperS.isEmpty()){
            mainS.push(helperS.pop());
        }
    }

    int remove() {
        if(mainS.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        
        return mainS.pop();
    }

    int peek() {
        if(mainS.isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        
        return mainS.peek();        
    }
}
