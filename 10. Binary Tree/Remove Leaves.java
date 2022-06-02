public static Node removeLeaves(Node node){
      if(node == null) return null;
      
      // leaf node -> delete node
      if(node.left == null && node.right == null)
        return null;
        
      Node leftChild = removeLeaves(node.left);
      Node rightChild = removeLeaves(node.right);
      
      node.left = leftChild;
      node.right = rightChild;
      
      // non-leaf node
      return node;
  }


  // void return type : 1 edge case is not handled: root is leaf (1 node)
  public static void removeLeaves(Node node){
      if(node == null) return; // root is null (0 nodes)
      
      if(node.left != null){
          // if left child is leaf node
          if(node.left.left == null && node.left.right == null){
              node.left = null;
          } else {
            removeLeaves(node.left);   
          }
      } 
      
      if(node.right != null){
          // if right child is leaf node
          if(node.right.left == null && node.right.right == null){
              node.right = null;
          } else {
              removeLeaves(node.right);
          }
      }
  }

// in main method
// removeLeaves(root)
// root = removeLeaves(root);
