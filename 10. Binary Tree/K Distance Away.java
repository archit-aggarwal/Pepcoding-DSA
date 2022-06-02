public static ArrayList<Node> nodeToRootPath(Node node, int data){
      if(node == null) // negative base case 
         return new ArrayList<>();
      
      if(node.data == data){ // positive base case
         ArrayList<Node> base = new ArrayList<>();
         base.add(node);
         return base;
      }
      
      ArrayList<Node> lres = nodeToRootPath(node.left, data);
      if(lres.size() > 0){
          lres.add(node);
          return lres;
      }
      
      ArrayList<Node> rres = nodeToRootPath(node.right, data);
      if(rres.size() > 0){
          rres.add(node);
          return rres;
      }
      
      return new ArrayList<>();
  }
  
  public static void printKLevelsDown(Node node, int k, Node blockage){
    if(node == null || k < 0 || node == blockage) 
        return;
    if(k == 0){
        System.out.println(node.data);
        return;
    }
    
    printKLevelsDown(node.left, k - 1, blockage);
    printKLevelsDown(node.right, k - 1, blockage);
  }
  
  public static void printKNodesFar(Node node, int data, int k) {
    ArrayList<Node> n2rpath = nodeToRootPath(node, data);
    
    int distance = k;
    for(int i=0; i<n2rpath.size(); i++){
        if(distance < 0) break;
        Node blockage = (i == 0) ? null : n2rpath.get(i - 1);    
        printKLevelsDown(n2rpath.get(i), distance, blockage);
        distance--;
    }
  }
