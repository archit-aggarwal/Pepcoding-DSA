public static int size(Node node) {
      if(node == null) return 0;
      
      int lsize = size(node.left);
      int rsize = size(node.right);
      return lsize + rsize + 1;
  }

  public static int sum(Node node) {
      if(node == null) return 0;
      
      int lsum = sum(node.left);
      int rsum = sum(node.right);
      return lsum + rsum + node.data;      
  }

  public static int max(Node node) {
        if(node.right == null) 
            return node.data;
        return max(node.right);
  }

  public static int min(Node node) {
       if(node.left == null) 
            return node.data;
       return min(node.left);
  }

  public static boolean find(Node node, int data){
      if(node == null) return false;
      if(node.data == data) return true;
      if(data < node.data)
        return find(node.left, data);
      return find(node.right, data);
  }  
