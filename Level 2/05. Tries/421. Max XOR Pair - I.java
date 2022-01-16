class Solution {
    public static class Node {
        Node left;
        Node right;
    }

    public void insert(Node root, int val) {
        for (int i = 31; i >= 0; i--) {
            int bit = val & (1 << i);

            if (bit == 0) {
                if (root.left == null)
                    root.left = new Node();
                root = root.left;
            } else {
                if (root.right == null)
                    root.right = new Node();
                root = root.right;
            }
        }
    }

    public int search(Node root, int val) {
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = val & (1 << i);

            if (bit == 0) {
                // pair exists with ith bit 1 -> XOR ith bit 1
                if (root.right != null) {
                    root = root.right;
                    maxXOR = maxXOR | (1 << i);
                } else {
                    root = root.left;
                }

            } else {
                // pair exists with ith bit 0 -> XOR ith bit 1
                if (root.left != null) {
                    root = root.left;
                    maxXOR = maxXOR | (1 << i);
                } else {
                    root = root.right;
                }
            }
        }
        return maxXOR;
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();

        int ans = 0;
        for (int val : nums) {
            insert(root, val);
            ans = Math.max(ans, search(root, val));
        }

        return ans;
    }
}