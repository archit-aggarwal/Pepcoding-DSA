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

// If X.level != Y.level return false (Neither Sibling Nor Cousin)
// Else If X.Parent == Y.Parent return false (Sibling but not Cousin)
// Else Return true (Same Level & Different Parent -> Cousin)

class Solution {
    int xLevel = 0, yLevel = 0, xParent = -1, yParent = -1;
    
    public void DFS(TreeNode root, int x, int y, int level){
        if(root == null) return;
        
        if(root.val == x) xLevel = level;
        if(root.val == y) yLevel = level;
        
        if(root.left != null){
            if(root.left.val == x) xParent = root.val;
            if(root.left.val == y) yParent = root.val;
        }
        
        if(root.right != null){
            if(root.right.val == x) xParent = root.val;
            if(root.right.val == y) yParent = root.val;
        }
        
        DFS(root.left, x, y, level + 1);
        DFS(root.right, x, y, level + 1);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        DFS(root, x, y, 0);
        
        if(x == y) return false;
        if(xLevel != yLevel) return false;
        if(xParent == yParent) return false;
        return true;
    }
}