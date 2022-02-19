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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int count = q.size();
            List<Integer> level = new ArrayList<>();
            while(count-- > 0){
                TreeNode curr = q.remove();
                level.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(level);
        }
        
        return res;
    }
}