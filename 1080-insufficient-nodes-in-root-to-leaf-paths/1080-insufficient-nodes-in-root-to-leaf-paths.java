/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class Pair{
        int sum;
        TreeNode node;
        boolean isNull;
        
        Pair(int sum, TreeNode node, boolean isNull){
            this.sum = sum;
            this.node = node;
            this.isNull = isNull;
        }
    }
    
    public Pair helper(TreeNode root, int sum, int limit){
        if(root == null) return new Pair(0, null, true);
        
        sum += root.val;
        Pair left = helper(root.left, sum, limit);
        root.left = left.node;
        
        Pair right = helper(root.right, sum, limit);
        root.right = right.node;
        
        if(left.node != null)  
            return new Pair(left.sum + root.val, root, false);
        
        if(right.node != null)
            return new Pair(right.sum + root.val, root, false);
        
        
        int maxSum = sum;
        if(left.isNull == false && right.isNull == false) 
            maxSum += Math.max(right.sum, left.sum);
        else if(left.isNull == false)
            maxSum += left.sum;
        else if(right.isNull == false)
            maxSum += right.sum;
            
        if(maxSum < limit) return new Pair(maxSum - sum + root.val, null, false);
        return new Pair(maxSum - sum + root.val, root, false);
        
    }
    
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, 0, limit).node;
    }
}