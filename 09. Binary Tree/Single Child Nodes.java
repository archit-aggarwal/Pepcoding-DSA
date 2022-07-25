public static void printSingleChildNodes(Node node, Node parent){
      if(node == null) return;
      
      if(parent != null && parent.left == null){
          System.out.println(node.data);
      }
      
      if(parent != null && parent.right == null){
          System.out.println(node.data);
      }
      
      printSingleChildNodes(node.left, node);
      printSingleChildNodes(node.right, node);
  }
  
  public static void printSingleChildNodes(Node node){
      if(node == null) return;

    //   if(node.left == null && node.right == null){
    //       // leaf node
    //       return;
    //   }
      
    //   if(node.left != null){
    //       System.out.println(node.right.data);
    //   }
      
    //   if(node.right == null){
    //       System.out.println(node.left.data);
    //   }
    
      if((node.left == null) ^ (node.right == null)){
          
          if(node.left == null)
            System.out.println(node.right.data);
          else System.out.println(node.left.data);
      }
      
      printSingleChildNodes(node.left);
      printSingleChildNodes(node.right);
}
