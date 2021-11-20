public void removeDuplicates(){
      if(head == null) return;
      
      Node curr = head;
      while(curr.next != null){
          
          Node ahead = curr.next;
          
          if(curr.data != ahead.data) {
              
              // move pointer
              curr = curr.next;
              
          } else {
              
              // delete next node
              curr.next = curr.next.next;
              size--;
          }
      }
      
      tail = curr;
    }
