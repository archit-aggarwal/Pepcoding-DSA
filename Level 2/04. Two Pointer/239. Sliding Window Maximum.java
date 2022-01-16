class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        int window = 0;
        for (int i = 0; i < nums.length; i++) {
            if (q.size() > 0 && q.getFirst() <= i - k) {
                q.removeFirst();
            }

            while (q.size() > 0 && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }

            q.addLast(i);

            if (i >= k - 1)
                res[window++] = nums[q.getFirst()];
        }

        return res;
    }
}