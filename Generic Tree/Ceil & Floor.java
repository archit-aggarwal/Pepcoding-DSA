  static int ceil = Integer.MAX_VALUE;
  static int floor = Integer.MIN_VALUE;

  public static void ceilAndFloor(Node node, int data) {
      if(node.data < data)
          floor = Math.max(floor, node.data);
      else if(node.data > data)
          ceil = Math.min(ceil, node.data);
        
      for(Node child: node.children)
          ceilAndFloor(child, data);
  }

public static int kthLargest(Node node, int k){
    int ans = Integer.MAX_VALUE;  
      
    for(int i=1; i<=k; i++){
        floor = Integer.MIN_VALUE;
        ceilAndFloor(node, ans);
        ans = floor;
    }
    
    return ans;
  }
