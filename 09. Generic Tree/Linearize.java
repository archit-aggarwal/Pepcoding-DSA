public static Node getLastNode(Node curr){
    while(curr.children.size() > 0){
        curr = curr.children.get(0);
    }    
    return curr;
  }
  
  public static Node linearizeOpt(Node root) {
      if(root.children.size() == 0){
          return root;
      }
      
      Node lastTreetail = linearizeOpt(root.children.get(root.children.size() - 1));
      
      while(root.children.size() > 1) {
          Node lastTreehead = root.children.remove(root.children.size() - 1);
          Node secondLastTreetail = linearizeOpt(root.children.get(root.children.size() - 1));
          secondLastTreetail.children.add(lastTreehead);
      }
      
      return lastTreetail;
  }
  
  public static void linearize(Node root){
      // faith
      for(Node child: root.children){
          linearize(child);
      }
      
      // meeeting expectation
      while(root.children.size() > 1){
          
          Node lastTreeroot = root.children.remove(root.children.size() - 1);
          Node secondlastTreeroot = root.children.get(root.children.size() - 1);
          
          Node secondlastTreetail = getLastNode(secondlastTreeroot);
          secondlastTreetail.children.add(lastTreeroot);
      }
  }
