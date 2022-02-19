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
    public void DFS(TreeNode root, List<Integer> rightView, int level){
        if(root == null) return;
        
        if(level >= rightView.size())
            rightView.add(root.val);
        else rightView.set(level, root.val);
        
        DFS(root.left, rightView, level + 1);
        DFS(root.right, rightView, level + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        DFS(root, rightView, 0);
        return rightView;
    }
}