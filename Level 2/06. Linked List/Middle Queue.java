class FrontMiddleBackQueue {
    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();
    
    public void balance(){
        if((left.size() + right.size()) % 2 == 0){
            while(left.size() > right.size()){
                int val = left.removeLast();
                right.addFirst(val);
            }
            while(right.size() > left.size()){
                int val = right.removeFirst();
                left.addLast(val);
            }
        } else {
            while(left.size() > right.size() + 1){
                int val = left.removeLast();
                right.addFirst(val);
            }
            while(right.size() + 1 > left.size()){
                int val = right.removeFirst();
                left.addLast(val);
            }
        }
    }
    
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if(left.size() > right.size()){
            right.addFirst(left.getLast());
            left.removeLast();
        }
        
        left.addLast(val);
        balance();
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }
    
    public int popFront() {
        if(left.size() + right.size() == 0) return -1;
        int val = left.getFirst();
        left.removeFirst();
        balance();
        return val;
    }
    
    public int popMiddle() {
        if(left.size() + right.size() == 0) return -1;
        int val = left.getLast();
        left.removeLast();
        balance();
        return val;
    }
    
    public int popBack() {
        if(left.size() + right.size() == 0) return -1;
        if(right.size() == 0) {
            int val = left.getLast();
            left.removeLast();
            balance();
            return val;
        } else {
            int val = right.getLast();
            right.removeLast();
            balance();
            return val;
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
