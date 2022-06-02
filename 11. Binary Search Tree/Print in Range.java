public static void pir1(Node node, int d1, int d2) {
        if(node == null) return;
        
        if(!(node.data < d1))
            pir1(node.left, d1, d2);
        
        if(node.data >= d1 && node.data <= d2)
            System.out.println(node.data);
        
        if(!(node.data > d2))
            pir1(node.right, d1, d2);
  }

  public static void pir2(Node node, int d1, int d2){
      if(node == null) return;
      
      if(node.data < d1){
          
          pir2(node.right, d1, d2);
          
      } else if(node.data > d2){
          
          pir2(node.left, d1, d2);
          
      } else {
          
          pir2(node.left, d1, d2);
          System.out.println(node.data);
          pir2(node.right, d1, d2);
          
      }
  }
