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
    public void helper(TreeNode root, String path, List<String> paths){
        if(root == null){
            // if any only if tree is of 0 nodes
            return;
        }
        
        if(root.left == null && root.right == null){
            // leaf node
            paths.add(path + root.val);
            return;
        }
        
        helper(root.left, path + root.val + "->", paths);
        helper(root.right, path + root.val + "->", paths);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        helper(root, "", paths);
        return paths;
    }
}