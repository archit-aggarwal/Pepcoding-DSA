public Node getNodeAt(int idx) {
        // O(N) in worst case
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp;
    }
   
// Data Iterative
public void reverseDI() {
  // O(N ^ 2) Time
  int left = 0, right = size - 1;

  while(left < right){

    Node leftNode = getNodeAt(left);
    Node rightNode = getNodeAt(right);

    int temp = leftNode.data;
    leftNode.data = rightNode.data;
    rightNode.data = temp;

    left++; right--;
  }
}

// Pointer Iterative: O(N): (Must Learn)
public void reversePI()
    {
        if(head == null || head.next == null){
            // 0 nodes or 1 node
            return;
        }
        
        Node prev = null;
        Node curr = head;
        Node currNext = curr.next;
        
        while(curr != null){
            
            // Pointer Updation
            curr.next = prev;
            
            // Process Next Node
            prev = curr;
            curr = currNext;
            
            if(currNext != null)
                currNext = currNext.next;
        }
        
        // Update head, tail
        tail = head;
        head = prev;
    }


// Data Recursive: O(N):
// 2 Methods: Using Data Member left & Using Return Type

    Node left;
    public void reverseDRHelper1(Node right, int counter){
        if(right == null)  return;
        
        reverseDRHelper1(right.next, counter + 1);
        
        if(counter >= size/2){
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }
        
        left = left.next;
    }
    
    public Node reverseDRHelper2(Node left, Node right, int counter){
        if(right == null)  return left;
        
        left = reverseDRHelper2(left, right.next, counter + 1);
        
        if(counter >= size/2){
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }
        
        left = left.next;
        return left;
    }
    
    public void reverseDR() {
  //       left = head;
  //       reverseDRHelper1(head, 0);
    
        reverseDRHelper2(head, head, 0);
        
    }


// Pointer Recursive: O(N)
private void reversePRHelper(Node curr){
      if(curr == tail){
          // base case: last  node
          return;
      }
      
      reversePRHelper(curr.next);
      
      // Process Next Node in postorder
      curr.next.next = curr;
    }

    public void reversePR(){
      reversePRHelper(head);
      
      // Update Last Node's next as null
      head.next = null;
      
      // swap Head & Tail
      Node temp = head;
      head = tail;
      tail = temp;
    }
