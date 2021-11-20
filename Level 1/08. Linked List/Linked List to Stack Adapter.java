public static class LLToStackAdapter {
    LinkedList<Integer> list;

    public LLToStackAdapter() {
      list = new LinkedList<>();
    }

    int size() {
        return list.size();
    }

    void push(int val) {
        list.addFirst(val);
    }

    int pop() {
        if(list.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        
        int val = list.removeFirst();
        return val;
    }

    int top() {
        if(list.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        
        int val = list.getFirst();
        return val;        
    }
  }
