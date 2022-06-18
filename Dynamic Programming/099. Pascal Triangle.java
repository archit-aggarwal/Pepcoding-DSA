import java.util.*;

// LC: 118: Pascal Triangle - I: https://leetcode.com/problems/pascals-triangle/
// Time - O(N * K), Space - O(N ^ 2) 2D DP
class Solution1 {
    public List<List<Integer>> generate(int rows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>());
        pascal.get(0).add(1);

        for (int n = 1; n < rows; n++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // nC0

            for (int k = 1; k < n; k++) {
                // nCk = n-1Ck-1 + n-1Ck
                int nCk = pascal.get(n - 1).get(k) + pascal.get(n - 1).get(k - 1);
                row.add(nCk);
            }

            row.add(1); // nCn
            pascal.add(row);
        }

        return pascal;
    }
}

// LC: 119: Pascal Triangle - II:
// https://leetcode.com/problems/pascals-triangle-ii/

// Time - O(N * K), Space - O(N) 1D DP
class Solution2 {
    public List<Integer> getRow(int rows) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int n = 1; n <= rows; n++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1); // nC0

            for (int k = 1; k < n; k++) {
                // nCk = n-1Ck-1 + n-1Ck
                int nCk = prev.get(k) + prev.get(k - 1);
                curr.add(nCk);
            }

            curr.add(1); // nCn
            prev = curr;
        }

        return prev;
    }
}

// GfG: nCr modulo 10^9 + 7:
// https://practice.geeksforgeeks.org/problems/ncr1019/1

class Solution3 {
    static int nCr(int rows, int cols) {
        if (cols > rows)
            return 0;
        if (rows == 0 || rows == cols || cols == 0)
            return 1;

        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int n = 1; n <= rows; n++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1); // nC0

            for (int k = 1; k < n; k++) {
                // nCk = n-1Ck-1 + n-1Ck
                int nCk = (prev.get(k) + prev.get(k - 1)) % 1000000007;
                ;
                curr.add(nCk);
            }

            curr.add(1); // nCn
            prev = curr;
        }

        return prev.get(cols);
    }
}