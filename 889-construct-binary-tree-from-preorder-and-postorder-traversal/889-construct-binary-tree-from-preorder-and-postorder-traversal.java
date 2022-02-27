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
    public int find(int val, int[] postorder){
        for(int i=0; i<postorder.length; i++){
            if(postorder[i] == val) return i;
        }
        return -1;
    }
    
    public TreeNode construct(int[] preorder, int[] postorder, int prel, int prer,
                                int postl, int postr){
        if(prel > prer) return null;
        if(prel == prer) return new TreeNode(preorder[prel]);
        
        TreeNode root = new TreeNode(preorder[prel]);
        
        if(prel + 1 >= preorder.length) return root;
            
        int leftChild = preorder[prel + 1];
        int postIdx = find(leftChild, postorder);
        int leftCount = postIdx - postl + 1;
        root.left = construct(preorder, postorder, prel + 1, prel + leftCount, postl, postIdx);
        root.right = construct(preorder, postorder,  prel + leftCount + 1, prer, postIdx + 1, postr - 1);
        
        return root;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder, 0, preorder.length - 1, 
                                             0, postorder.length - 1);
    }
}