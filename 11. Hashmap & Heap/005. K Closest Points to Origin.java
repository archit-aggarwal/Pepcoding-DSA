import java.util.*;

// 973: https://leetcode.com/problems/k-closest-points-to-origin/

// Time - O(N + KLogN) if Efficient Constructor for Add 
// Space - O(K)

class Solution {
    static class Pair {
        public int x, y;
    }

    static class Euclidean implements Comparator<Pair> {
        public int compare(Pair c1, Pair c2) {
            double d1 = Math.sqrt(c1.x * c1.x + c1.y * c1.y);
            double d2 = Math.sqrt(c2.x * c2.x + c2.y * c2.y);

            if (d1 < d2) {
                // Smaller Value -> Higher Priority
                return -1;
            } else if (d1 > d2) {
                // Higher Value -> Lower Priority
                return 1;
            } else
                return 0;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new Euclidean());

        for (int i = 0; i < points.length; i++) {
            Pair p = new Pair();
            p.x = points[i][0];
            p.y = points[i][1];
            q.add(p);
        }

        int[][] res = new int[k][2];
        int count = 0;
        while (count < k) {
            Pair closest = q.remove();
            res[count][0] = closest.x;
            res[count][1] = closest.y;
            count++;
        }

        return res;
    }
}