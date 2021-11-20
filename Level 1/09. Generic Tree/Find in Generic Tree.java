public static boolean find(Node node, int data) {
    if(node.data == data) return true;
    
    for(Node child: node.children){
        boolean ans = find(child, data);
        
        if(ans == true) return true;
    }
    
    return false;
  }
