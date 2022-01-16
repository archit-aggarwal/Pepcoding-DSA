class Compute {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                q.addLast(i);
            }
        }

        long[] res = new long[N - K + 1];
        int window = 0;
        res[window++] = (q.size() == 0) ? 0 : A[q.getFirst()];

        for (int i = K; i < N; i++) {
            if (q.size() > 0 && q.getFirst() <= i - K) {
                q.removeFirst();
            }

            if (A[i] < 0) {
                q.addLast(i);
            }
            res[window++] = (q.size() == 0) ? 0 : A[q.getFirst()];
        }

        return res;
    }
}