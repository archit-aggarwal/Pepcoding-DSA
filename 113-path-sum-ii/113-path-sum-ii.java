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
    List<List<Integer>> paths;
    public void helper(TreeNode root, List<Integer> path, int target){
        if(root == null) return;
        
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target == root.val)
                paths.add(new ArrayList<>(path)); // deep copy
            
            path.remove(path.size() - 1);
            return;
        }
        
        helper(root.left, path, target - root.val);
        helper(root.right, path, target - root.val);
        path.remove(path.size() - 1); // backtrack
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<>();
        helper(root, new ArrayList<>(), targetSum);
        return paths;
    }
}