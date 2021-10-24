public static class isBSTPair{
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      boolean isBST = true;
      int count = 0;
  }
  
  static int maxCount = 0;
  static Node largestBST = null;
  
  public static isBSTPair largestBST(Node root){
      if(root == null) return new isBSTPair();
      
      isBSTPair left = largestBST(root.left);
      isBSTPair right = largestBST(root.right);
      
      isBSTPair curr = new isBSTPair();
      curr.count = left.count + right.count + 1;
      
      if(left.max < root.data && root.data < right.min
          && left.isBST && right.isBST){
          curr.isBST = true;
          
          if(curr.count > maxCount){
            maxCount = curr.count;
            largestBST = root;
          }
          
      } else {
          curr.isBST = false;
      }
      
      curr.min = Math.min(root.data, Math.min(left.min, right.min));
      curr.max = Math.max(root.data, Math.max(left.max, right.max));
      return curr;
  }


// approach 2: return type
public static class isBSTPair{
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      boolean isBST = true;
      int count = 0;
      int maxCount = 0;
      Node largestBST = null;
  }
  
public static isBSTPair largestBST(Node root){
      if(root == null) return new isBSTPair();
      
      isBSTPair left = largestBST(root.left);
      isBSTPair right = largestBST(root.right);
      
      isBSTPair curr = new isBSTPair();
      curr.count = left.count + right.count + 1;
      
      curr.maxCount = (left.maxCount > right.maxCount) ? left.maxCount : right.maxCount;
      curr.largestBST = (left.maxCount > right.maxCount) ? left.largestBST : right.largestBST;
      
      if(left.max < root.data && root.data < right.min
          && left.isBST && right.isBST){
          curr.isBST = true;
          
          if(curr.count > curr.maxCount){
            curr.maxCount = curr.count;
            curr.largestBST = root;
          }
          
      } else {
          curr.isBST = false;
      }
      
      curr.min = Math.min(root.data, Math.min(left.min, right.min));
      curr.max = Math.max(root.data, Math.max(left.max, right.max));
      return curr;
  }
