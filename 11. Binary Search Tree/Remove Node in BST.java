public static Node remove(Node node, int data) {
    if(node == null){
        // if node does not exist
        return null;
    }
    
    if(node.data == data){
        
        if(node.left == null && node.right == null){
            // leaf node
            return null;
            
        } else if(node.left == null){
            // only right child
            return node.right;
            
        } else if(node.right == null){
            // only left child
            return node.left;
            
        } else {
            // 2 child
            int inorderPredecessor = max(node.left);
            node.data = inorderPredecessor;
            node.left = remove(node.left, inorderPredecessor);
        }
        
    } else if(node.data < data)
        node.right = remove(node.right, data);
    else node.left = remove(node.left, data);
    
    return node;
  }
