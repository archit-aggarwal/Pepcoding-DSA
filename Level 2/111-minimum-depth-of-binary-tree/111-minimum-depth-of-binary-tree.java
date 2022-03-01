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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null)
            return 1; // Leaf Node
        
        if(root.left == null) // Only Right Child
            return 1 + minDepth(root.right);
        
        if(root.right == null) // Only Left Child
            return 1 + minDepth(root.left);
        
        // Node with 2 Childs
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}