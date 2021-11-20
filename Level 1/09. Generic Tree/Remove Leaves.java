public static void removeLeavesHelper(Node root) {
      // Meeting Expectation
      for(int i=root.children.size() - 1; i>=0; i--){
          
          Node child = root.children.get(i);
          
          if(child.children.size() == 0) // if child node is leaf node 
              root.children.remove(i);
      }
      
      // Faith
      for(Node child: root.children){
          removeLeavesHelper(child);
      }
  }
  
  public static void removeLeaves(Node root) {
      if(root.children.size() == 0){
          root = null;
          return;
      }
      removeLeavesHelper(root);
  }
