// Create Left Clone with return type
public static Node createLeftCloneTree(Node node){
      if(node == null) return null;
      
      Node leftRoot = createLeftCloneTree(node.left);
      Node rightRoot = createLeftCloneTree(node.right);
      
      Node copyNode = new Node(node.data);
      copyNode.left = leftRoot;
      node.left = copyNode;
      
      return node;
  }

// Create Left Clone without return type
public static void createLeftCloneTree(Node node){
      if(node == null) return;
      
      createLeftCloneTree(node.left);
      createLeftCloneTree(node.right);
      
      Node copyNode = new Node(node.data);
      copyNode.left = node.left;
      node.left = copyNode;
  }

// Transform back to Normal Tree
public static Node transBackFromLeftClonedTree(Node node){
      if(node == null) return null;
      
      // faith
      Node leftRoot = transBackFromLeftClonedTree(node.left.left);
      Node rightRoot = transBackFromLeftClonedTree(node.right);
      
      // meeting expectation -> delete our duplicate
      node.left = leftRoot;
      return node;
  }
