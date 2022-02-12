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
//     public int height(TreeNode root){
//         if(root == null) return 0;
//         return 1 + Math.max(height(root.left), height(root.right));
//     }
    
//     public int diameter(TreeNode root) {
//         if(root == null) return 0;
        
//         int lh = height(root.left);
//         int rh = height(root.right);
        
//         int ld = diameter(root.left);
//         int rd = diameter(root.right);
//         return Math.max(lh + rh + 1, Math.max(ld, rd));
//     }
    
    public int globalDia = 0;
    public int diameter(TreeNode root){
        if(root == null) return 0;
        
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        
        // Global Variable Strategy or Travel & Change Strategy
        globalDia = Math.max(globalDia, lh + rh + 1); 
        return Math.max(lh, rh) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        diameter(root);
        return globalDia - 1;
        // Diameter in Terms of Edges = Diamater in Terms of Nodes - 1
    }
}