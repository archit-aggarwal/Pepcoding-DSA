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
    public TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> inorder, int inL, int inR, int postIdx){
        if(inL > inR) return null;
        
        TreeNode curr = new TreeNode(postorder[postIdx]);
        int inIdx = inorder.get(postorder[postIdx]);
        
        curr.left = buildTree(postorder, inorder, inL, inIdx - 1, postIdx - 1 - (inR - inIdx));
        curr.right = buildTree(postorder, inorder, inIdx + 1, inR, postIdx - 1);
        return curr;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);
        
        return buildTree(postorder, hm, 0, inorder.length - 1, postorder.length - 1);
    }
}