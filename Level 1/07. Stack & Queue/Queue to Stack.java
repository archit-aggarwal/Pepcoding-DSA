// Push Efficient
public static class QueueToStackAdapter {
    Queue<Integer> mainQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
    }

    void push(int val) {
        mainQ.add(val);
    }

    int pop() {
        Queue<Integer> helperQ = new ArrayDeque<>();
        int counter = mainQ.size() - 1;
        for(int i = 1; i <= counter; i++)
            helperQ.add(mainQ.remove());
        
        int val = mainQ.remove();
        mainQ = helperQ;
        return val;
    }

    int top() {
        Queue<Integer> helperQ = new ArrayDeque<>();
        int counter = mainQ.size() - 1;
        for(int i = 1; i <= counter; i++)
            helperQ.add(mainQ.remove());
        
        int val = mainQ.remove();
        helperQ.add(val);
        mainQ = helperQ;
        return val;
    }
}

// Pop Efficient
public static class QueueToStackAdapter {
    Queue<Integer> mainQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
    }

    void push(int val) {
        Queue<Integer> helperQ = new ArrayDeque<>();
        while(mainQ.size() > 0){
            helperQ.add(mainQ.remove());
        }
        
        mainQ.add(val);
        while(helperQ.size() > 0){
            mainQ.add(helperQ.remove());
        }
    }

    int pop() {
        if(size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        
        return mainQ.remove();
    }

    int top() {
        if(size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        
        return mainQ.peek();
    }
  }
