public static Node add(Node node, int data) {
      if(node == null){
          Node newNode = new Node(data, null, null);
          return newNode;
      }
      
      if(node.data == data) return node;
      
      else if(node.data < data) 
        node.right = add(node.right, data);
      else  
        node.left = add(node.left, data);
      
      return node;
  }
