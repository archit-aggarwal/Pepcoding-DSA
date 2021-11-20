  // O(N) Time, O(1) Extra Space  
  public int mid(){
        Node slow = head;
        Node fast = head;
        
        // when fast becomes last node or second last node, then stop
        while(fast != tail && fast.next != tail){ //  while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
