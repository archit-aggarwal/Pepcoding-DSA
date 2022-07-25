public static void inorder(Node root){
    if(root == null) return;
    
    inorder(root.left);
    System.out.println(root.data);
    inorder(root.right);
  }
  
  public static void revInorder(Node root){
    if(root == null) return;
    
    revInorder(root.right);
    System.out.println(root.data);
    revInorder(root.left);
  }
