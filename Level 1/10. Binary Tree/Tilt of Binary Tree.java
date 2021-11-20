static int tilt = 0;
  public static int tilt(Node node){
    if(node == null) return 0;
    
    int lsum = tilt(node.left);
    int rsum = tilt(node.right);
    
    int tiltAtnode = Math.abs(lsum - rsum);
    tilt += tiltAtnode;
    
    return lsum + rsum + node.data;
  }
