/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int DFS(TreeNode root, TreeNode target, int k, List<Integer> res){
        if(root == null) return -1;
        if(root == target){
            kLevelDown(root, null, k, res);
            return 1;
        }
        
        int left = DFS(root.left, target, k, res);
        if(left >= 0){
            kLevelDown(root, root.left, k - left, res);
            return left + 1;
        }
        
        int right = DFS(root.right, target, k, res);
        if(right >= 0){
            kLevelDown(root, root.right, k - right, res);
            return right + 1;
        }
        
        return -1;
    }
    
    public void kLevelDown(TreeNode root, TreeNode blocker, int k, List<Integer> res){
        if(k < 0 || root == null || root == blocker)  return;
        if(k == 0){
            res.add(root.val);
            return;
        }
        
        kLevelDown(root.left, blocker, k - 1, res);
        kLevelDown(root.right, blocker, k - 1, res);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        DFS(root, target, k, res);
        return res;
    }
}