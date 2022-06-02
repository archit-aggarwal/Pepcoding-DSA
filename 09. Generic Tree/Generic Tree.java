private static class Node{
      int data;
      ArrayList<Node> children;
      
      Node(int data){
          this.data = data;
          this.children = new ArrayList<>();
      }
      
      Node(){
          this.data = 0;
          this.children = new ArrayList<>();
      }
  }

public static Node construct(int[] arr) {
    Node root = null;
    Stack<Node> stk = new Stack<>();
    
    for(int i=0; i<arr.length; i++){
        
        if(arr[i] != -1){
            
            Node child = new Node(arr[i]);
            
            if(stk.isEmpty()){
                // root node
                root = child;
            } else {
                Node parent = stk.peek();
                parent.children.add(child);
            }
            
            
            stk.push(child);
            
        } else {
            // delimeter
            stk.pop();
        }
    }
    
    return root;
  }

public static void display(Node root) {
      if(root == null) return;
      
      // Meeting Expectation
      print(root);
      
      // faith
      for(Node child: root.children){
            display(child);
      }
  }
