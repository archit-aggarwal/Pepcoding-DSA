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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        odd.push(root);
        int level = 1;
        
        while(odd.size() > 0 || even.size() > 0){
            List<Integer> oned = new ArrayList<>();
            if(level % 2 == 1){
                while(odd.size() > 0){
                    TreeNode curr = odd.pop();
                    oned.add(curr.val);
                    
                    if(curr.left != null) even.push(curr.left);
                    if(curr.right != null) even.push(curr.right);
                }
            }   
            else {
                while(even.size() > 0){
                    TreeNode curr = even.pop();
                    oned.add(curr.val);
                    
                    if(curr.right != null) odd.push(curr.right);
                    if(curr.left != null) odd.push(curr.left);
                }
            }
            
            level++;
            res.add(oned);
        }
        return res;
    }
}