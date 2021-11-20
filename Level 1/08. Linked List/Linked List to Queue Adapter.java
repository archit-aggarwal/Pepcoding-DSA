public static class LLToQueueAdapter {
    LinkedList<Integer> list;

    public LLToQueueAdapter() {
      list = new LinkedList<>();
    }

    int size() {
        return list.size();
    }

    void add(int val) {
        list.addLast(val);
    }

    int remove() {
        if(list.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        
        int val = list.removeFirst();
        return val;
    }

    int peek() {
        if(list.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        
        int val = list.getFirst();
        return val;
    }
  }
