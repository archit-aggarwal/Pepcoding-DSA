import java.util.*;

// 264. https://leetcode.com/problems/ugly-number-ii/

// Using 3 Pointer Technique
class Solution1 {
    // Time: O(N), Space: O(N) for Visited Array
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;

        // Pointers Pointing to Indices not Values
        int ptr2 = 0, ptr3 = 0, ptr5 = 0;

        ArrayList<Integer> ugly = new ArrayList<>();
        ugly.add(1); // to add the 1st ugly no at index 0

        for (int i = 1; i < n; i++) {
            int a = ugly.get(ptr2) * 2;
            int b = ugly.get(ptr3) * 3;
            int c = ugly.get(ptr5) * 5;

            int min = Math.min(a, Math.min(b, c));
            ugly.add(min);

            if (min == a)
                ptr2++;
            if (min == b)
                ptr3++;
            if (min == c)
                ptr5++;
        }

        return ugly.get(n - 1);
    }
}

// Using Priority Queue
class Solution2 {
    // O(N * Log N) Time, O(N) Space for Priority Queue + Visited HashSet
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;

        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1l);
        HashSet<Long> vis = new HashSet<>();

        int idx = 0;
        while (q.size() > 0) {
            long min = q.remove();
            if (vis.contains(min) == true)
                continue;

            idx++;
            if (idx == n)
                return (int) min;

            vis.add(min);
            q.add(min * 2l);
            q.add(min * 3l);
            q.add(min * 5l);
        }

        return 1;
    }
}