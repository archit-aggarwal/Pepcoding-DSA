  public static void printKLevelsDown(Node node, int k){
    if(node == null || k < 0) return;
    if(k == 0){
        System.out.println(node.data);
        return;
    }
    
    printKLevelsDown(node.left, k - 1);
    printKLevelsDown(node.right, k - 1);
  }
