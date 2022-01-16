import java.util.*;

class Solution {
    public static class Node {
        Node left = null;
        Node right = null;
    }

    public void insert(Node curr, int val) {
        for (int i = 31; i >= 0; i--) {
            if ((val & (1 << i)) == 0) {
                if (curr.left == null)
                    curr.left = new Node();
                curr = curr.left;
            } else {
                if (curr.right == null)
                    curr.right = new Node();
                curr = curr.right;
            }
        }
    }

    public int search(Node curr, int val) {
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if ((val & (1 << i)) == 0) {

                if (curr.right != null) {
                    curr = curr.right;
                    ans = ans | (1 << i);
                } else
                    curr = curr.left;

            } else {

                if (curr.left != null) {
                    curr = curr.left;
                    ans = ans | (1 << i);
                } else
                    curr = curr.right;
            }
        }

        return ans;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[][] q = new int[queries.length][3];
        for (int i = 0; i < q.length; i++) {
            q[i] = new int[] { queries[i][0], queries[i][1], i };
        }

        Arrays.sort(q, (a, b) -> (a[1] - b[1]));
        Arrays.sort(nums);

        int[] res = new int[queries.length];
        int idx = 0;
        Node root = new Node();

        for (int i = 0; i < queries.length; i++) {
            // Insertion
            while (idx < nums.length && nums[idx] <= q[i][1]) {
                insert(root, nums[idx]);
                idx++;
            }

            if (idx == 0)
                res[q[i][2]] = -1;
            else
                res[q[i][2]] = search(root, q[i][0]);
        }
        return res;
    }
}
