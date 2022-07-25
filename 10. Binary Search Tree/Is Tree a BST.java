 public static class isBSTPair{
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      boolean isBST = true;
  }
  
  // postorder solution - o(n)
  public static isBSTPair isBST(Node root){
      if(root == null) return new isBSTPair();
      
      isBSTPair left = isBST(root.left);
      isBSTPair right = isBST(root.right);
      
      isBSTPair curr = new isBSTPair();
      if(left.max < root.data && root.data < right.min
         && left.isBST && right.isBST){
          curr.isBST = true;
      } else {
          curr.isBST = false;
      }
      
      curr.min = Math.min(root.data, Math.min(left.min, right.min));
      curr.max = Math.max(root.data, Math.max(left.max, right.max));
      return curr;
  }
  
  // poor O(n^2) time solution
  public static boolean isBST(Node root){
      if(root == null) return true;
      
      boolean lres = isBST(root.left);
      boolean rres = isBST(root.right);
      
      int leftMax = max(root.left);
      int rightMin = min(root.right);
      
      if(leftMax < root.data && root.data < rightMin
         && left.isBST && right.isBST){
             return true;
      } 
      
      return false;
  }
  
  // preorder solution - o(n)
  public static boolean isBST(Node root, int min, int max){
      if(root == null) return true;
      
      if(root.data > min && root.data < max){
          boolean lres = isBST(root.left, min, root.data);
          boolean rres = isBST(root.right, root.data, max);
          return lres && rres;
      }
      
      return false;
  }
