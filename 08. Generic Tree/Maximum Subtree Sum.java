  static int maxSum = Integer.MIN_VALUE;
  static Node maxSumNode = null;
  
  public static int subtreeSum(Node root){
      int sum = root.data;
      for(Node child: root.children){
          sum += subtreeSum(child);
      }
      
      if(sum > maxSum){
          maxSum = sum;
          maxSumNode = root;
      }
      
      return sum;
  }
  
  public static class Pair{
      int maxSum;
      Node maxSumNode;
      int sum;
      
      Pair(int sum){
          this.sum = sum;
      }
  }
  
  public static Pair subtreeSum2(Node root){
      Pair ans = new Pair(root.data);
      for(Node child: root.children){
          Pair temp = subtreeSum2(child);
          ans.sum += temp.sum;
          
          if(temp.maxSum > ans.maxSum){
              ans.maxSum = temp.maxSum;
              ans.maxSumNode = temp.maxSumNode;
          }
      }
      
      if(ans.sum > ans.maxSum){
            ans.maxSum = ans.sum;
            ans.maxSumNode = root;
      }
      
      return ans;
  }
