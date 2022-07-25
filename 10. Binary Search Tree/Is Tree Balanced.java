public static class balPair{
    int height = 0;
    boolean isBal = true;
  }
  
  public static balPair isBalanced(Node root){
      if(root == null) return new balPair();
      
      balPair left = isBalanced(root.left);
      balPair right = isBalanced(root.right);
      
      balPair curr = new balPair();
      
      if(left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1){
          curr.isBal = true;
      } else {
          curr.isBal = false;
      }
      
      curr.height = Math.max(left.height, right.height) + 1;
      return curr;
  }
