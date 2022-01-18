class MyLinkedList {
    public static class Node{
        int data;
        Node next;    
    }
    
    Node head;
    Node tail;
    int size;
    
    public int get(int idx) {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
          } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
              temp = temp.next;
            }
            return temp.data;
          }
    }
    
    public void addAtHead(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = head;
          head = temp;

          if(size == 0){
            tail = temp;
          }

          size++;
    }
    
    public void addAtTail(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = null;

          if (size == 0) {
            head = tail = temp;
          } else {
            tail.next = temp;
            tail = temp;
          }

          size++;
    }
    
    public void addAtIndex(int idx, int val) {
          if(idx < 0 || idx > size){
            return;
          } else if(idx == 0){
            addAtHead(val);
          } else if(idx == size){
            addAtTail(val);
          } else {
            Node node = new Node();
            node.data = val;

            Node temp = head;
            for(int i = 0; i < idx - 1; i++){
              temp = temp.next;
            }
            node.next = temp.next;

            temp.next = node;
            size++;
          }
    }
    
    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

     public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
      }
    }

    public void deleteAtIndex(int idx) {
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        
        if(idx < 0 || idx >= size){
            System.out.println("Invalid arguments");
            return;
        }
        
        if(idx == 0) removeFirst();
        else if(idx == size - 1) removeLast();
        else {
            Node prev = head;
            for(int i=0; i<idx-1; i++){
                prev = prev.next;
            }
            
            prev.next = prev.next.next;
            size--;
        }  
    }

}
