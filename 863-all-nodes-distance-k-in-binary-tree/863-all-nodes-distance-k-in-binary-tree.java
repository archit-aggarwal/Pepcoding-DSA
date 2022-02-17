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
    public boolean path(TreeNode root, TreeNode target, ArrayList<TreeNode> r2nPath){
        if(root == null) return false;
        if(root == target){
            r2nPath.add(root);
            return true;
        }
        
        r2nPath.add(root);
        if(path(root.left, target, r2nPath) == true) return true;
        if(path(root.right, target, r2nPath) == true) return true;
        r2nPath.remove(r2nPath.size() - 1);
        return false;
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
        ArrayList<TreeNode> r2nPath = new ArrayList<>();
        if(path(root, target, r2nPath) == false) return new ArrayList<>();
        
        r2nPath.add(null);
        List<Integer> res = new ArrayList<>();
        for(int i=r2nPath.size()-2; i>=0; i--){
            TreeNode curr = r2nPath.get(i);
            TreeNode blocker = r2nPath.get(i + 1);
            kLevelDown(curr, blocker, k, res);
            k--;
        }
        return res;
    }
}