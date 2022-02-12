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
    
//     public int diameter(TreeNode root, int[] globalDia){
//         if(root == null) return 0;
        
//         int lh = diameter(root.left, globalDia);
//         int rh = diameter(root.right, globalDia);
        
//         // Global Variable Strategy or Travel & Change Strategy
//         globalDia[0] = Math.max(globalDia[0], lh + rh + 1); 
//         return Math.max(lh, rh) + 1;
//     }
    
    public static class Pair{
        int height;
        int diameter; // Diameter is of entire subtree
    }
    
    public Pair diameter(TreeNode root){
        if(root == null) return new Pair();
        
        Pair left = diameter(root.left);
        Pair right = diameter(root.right);
        
        Pair curr = new Pair();
        curr.height = Math.max(left.height, right.height) + 1;
        curr.diameter = left.height + right.height + 1;
        curr.diameter = Math.max(curr.diameter, Math.max(left.diameter, right.diameter));
        return curr;
    }
    
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        // Diameter in Terms of Edges = Diamater in Terms of Nodes - 1
        return diameter(root).diameter - 1;
    }
}