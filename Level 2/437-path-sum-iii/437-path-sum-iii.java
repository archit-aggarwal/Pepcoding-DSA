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

// O(N ^ 2) Approach
// class Solution {
    
//     public int dfs(TreeNode root, int targetSum){
//         if(root == null) return 0;
        
//         targetSum -= root.val;
        
//         int count = 0;
//         if(targetSum == 0)
//             count++;
        
//         return count + dfs(root.left, targetSum) + dfs(root.right, targetSum);
//     }
    
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null) return 0;
//         return dfs(root, targetSum) + pathSum(root.left, targetSum) + 
//             pathSum(root.right, targetSum);
//     }
// }

// O(N) Approach
class Solution{
    HashMap<Integer, Integer> freq = new HashMap<>();
    
    public int helper(TreeNode root, int targetSum, int prefSum){
        if(root == null) return 0;
        
        prefSum += root.val;
        int count = freq.getOrDefault(prefSum - targetSum, 0);
        freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
        
        count += helper(root.left, targetSum, prefSum);
        count += helper(root.right, targetSum, prefSum);
        
        freq.put(prefSum, freq.getOrDefault(prefSum, 0) - 1); // Backtrack
        
        return count;
    }
    
    public int pathSum(TreeNode root, int targetSum){
        if(root == null) return 0;
        freq.put(0, 1);
        return helper(root, targetSum, 0);
    }
}