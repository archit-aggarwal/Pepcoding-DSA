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
    public TreeNode helper(TreeNode root){
        if(root == null) return null;
        root.left = helper(root.left);
        root.right = helper(root.right);
        if(root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }
    public int count(TreeNode root){
        if(root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
    
    public TreeNode pruneTree(TreeNode root) {
        if(count(root) >= 150) return null;
        return helper(root);
    }
}