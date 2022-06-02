public void kReverse(int k) {
      LinkedList old = new LinkedList();
      
      while (this.size() > 0) {
        LinkedList curr = new LinkedList();
        
        if (this.size() >= k) {

          for (int i = 0; i < k; i++) {
              int data = this.head.data;
              curr.addFirst(data);
              this.removeFirst();
          }
          
        } else {
            
          while (this.size() > 0) {
              int data = this.head.data;
              curr.addLast(data);
              this.removeFirst();
          }
          
        }
        
        if(old.head == null){
            old.head = curr.head;
            old.tail = curr.tail;
            old.size = curr.size;
        } else {
            old.tail.next = curr.head;
            old.tail = curr.tail;
            old.size += curr.size;
        }
        
      }
      
      this.head = old.head;
      this.tail = old.tail;
      this.size = old.size;
    }
