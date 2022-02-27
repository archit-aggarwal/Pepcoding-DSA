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
    List<TreeNode> res;
    HashMap<String, Integer> duplicates;
        
    public String DFS(TreeNode root){
        if(root == null) return "#";
        
        String hash = root.val + "," + DFS(root.left) + "," + DFS(root.right);
        if(duplicates.containsKey(hash) == true && duplicates.get(hash) == 1){
            res.add(root);
        }
        
        duplicates.put(hash, duplicates.getOrDefault(hash, 0) + 1);
        return hash;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();    
        duplicates = new HashMap<>();
        DFS(root);
        return res;
    }
}