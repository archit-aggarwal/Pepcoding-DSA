public static void mirror(Node node){
    // write your code here
    Collections.reverse(node.children);
    
    for(Node child: node.children){
        mirror(child);
    }
  }
