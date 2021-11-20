// leetcode 108. Convert Sorted Array to Binary Search Tree
class Solution {
    public TreeNode construct(int[] nums, int l, int r){
        if(l > r) return null;
        
        int mid = (l + r) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = construct(nums, l, mid - 1);
        root.right = construct(nums, mid + 1, r);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length - 1);
        return root;
    }
}
