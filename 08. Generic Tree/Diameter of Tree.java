static int maxDiameter = 0;
  public static int diameter(Node root){
      
      int max1 = -1, max2 = -1;
      for(Node child: root.children){
          int hc = diameter(child);
          
          if(hc >= max1){
              max2 = max1;
              max1 = hc;
          } else if(hc >= max2){
              max2 = hc;
          } 
      }
      
      int dia = max1 + max2 + 2;
      maxDiameter = Math.max(dia, maxDiameter);
      
      return max1 + 1;
  }
