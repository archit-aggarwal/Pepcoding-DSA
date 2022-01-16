public class Solution {
    public int[] dNums(int[] A, int B) {
        int[] res = new int[A.length - B + 1];

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < B; i++) {
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }

        int window = 0;
        res[window++] = freq.size();

        for (int i = B; i < A.length; i++) {
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);

            if (freq.get(A[i - B]) == 1) {
                freq.remove(A[i - B]);
            } else {
                freq.put(A[i - B], freq.get(A[i - B]) - 1);
            }

            res[window++] = freq.size();
        }

        return res;
    }
}
