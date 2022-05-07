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
    int count, kthSmallest;
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        
        count--;
        if(count >= 0) 
            kthSmallest = root.val;
        
        inorder(root.right);
      }

    public int kthSmallest(TreeNode root, int k) {
        count = k; kthSmallest = -1;
        inorder(root);
        return kthSmallest;
    }
}