public static boolean find(Node node, int data){
     if(node == null) return false;
     // return (node.data == data) ? true : (find(node.left, data) || find(node.right, data));
     
     if(node.data == data) return true;
     
     boolean lres = find(node.left, data);
     if(lres == true) return true;
     
     boolean rres = find(node.right, data);
     if(rres == true) return true;
     
     return false;
  }
  
  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
      if(node == null) // negative base case 
         return new ArrayList<>();
      
      if(node.data == data){ // positive base case
         ArrayList<Integer> base = new ArrayList<>();
         base.add(node.data);
         return base;
      }
      
      ArrayList<Integer> lres = nodeToRootPath(node.left, data);
      if(lres.size() > 0){
          lres.add(node.data);
          return lres;
      }
      
      ArrayList<Integer> rres = nodeToRootPath(node.right, data);
      if(rres.size() > 0){
          rres.add(node.data);
          return rres;
      }
      
      return new ArrayList<>();
  }
  
  public static boolean rootToNodePath(Node node, int data, ArrayList<Integer> curr){
    if(node == null) return false;
    
    if(node.data == data){
        curr.add(node.data);
        return true;
    }
    
    curr.add(node.data);
    
    boolean left = rootToNodePath(node.left, data, curr);
    if(left == true) return true;
    boolean right = rootToNodePath(node.right, data, curr);
    if(right == true) return true;
    
    curr.remove(curr.size() - 1);
    return false;
  }
  
  public static void allRootToNodePath(Node node, int data, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
      if(node == null) // negative base case 
         return;
      
      curr.add(node.data);
         
      if(node.data == data){ // positive base case
         System.out.println(curr);
         
         ArrayList<Integer> temp = new ArrayList<>();
         for(Integer i: curr)
            temp.add(i);
         res.add(temp);
      }
      
      allRootToNodePath(node.left, data, curr, res);
      allRootToNodePath(node.right, data, curr, res);
      curr.remove(curr.size() - 1);
  }

