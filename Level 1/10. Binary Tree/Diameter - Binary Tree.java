 // we are returning diameter
  // o(n^2) solution
  public static int diameter1(Node node) {
      if(node == null) return 0;
      
      int lDia = diameter1(node.left);
      int rDia = diameter1(node.right);
      
      // meeting expectation
      int lh = height(node.left);
      int rh = height(node.right);
      int dia = lh + rh + 2;
      
      return Math.max(dia, Math.max(lDia, rDia));
  }
  
  static int maxDiameter = 0;
  // we are returning height, but calculating diameter
  // global variable (travel & change) strategy
  public static int diameter2(Node node){
    if (node == null) {
      return -1;
    }

    int lh = diameter2(node.left);
    int rh = diameter2(node.right);

    int dia = lh + rh + 2;
    maxDiameter = Math.max(maxDiameter, dia);

    return Math.max(lh, rh) + 1;
  }
  
  
  public static class diaPair{
    int height;
    int diameter;
    
    public diaPair(){
        height = -1;
        diameter = 0;
    }
  }
  
  // Return both diameter & height
  public static diaPair diameter3(Node node){
      if(node == null)
          return new diaPair();
          
      diaPair l = diameter3(node.left);
      diaPair r = diameter3(node.right);
      
      diaPair curr = new diaPair();
      curr.height = Math.max(l.height, r.height) + 1;
      
      int dia = l.height + r.height + 2;
      curr.diameter = Math.max(dia, Math.max(l.diameter, r.diameter));
      
      return curr;
  }


    // System.out.println(diameter1(root));
    
    // diameter2(root);
    // System.out.println(maxDiameter);
    
    // diaPair ans = diameter3(root);
    // System.out.println(ans.diameter);
