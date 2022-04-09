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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> lklist = new LinkedList<>();
        TreeNode left = null;
        for (int num: nums){
            TreeNode cur = new TreeNode(num);
            while (!lklist.isEmpty() && (lklist.peekFirst()).val < cur.val){
                cur.left = lklist.pop();
            }
            
            if (!lklist.isEmpty()){
                lklist.peekFirst().right = cur;
            }
            lklist.push(cur);
        }
        
        return lklist.peekLast();
    }
}