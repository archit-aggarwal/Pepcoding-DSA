import java.util.*;

class Q1 {
    int search(ArrayList<Integer> idx, int target) {
        if (idx.size() == 0)
            return -1;
        int left = 0, right = idx.size() - 1;
        int ans = idx.get(0);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (idx.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = idx.get(mid);
            }
        }
        return ans;
    }

    long solution(String a, String b) {
        ArrayList<Integer>[] idx = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            idx[i] = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            idx[a.charAt(i) - 'a'].add(i);
        }

        long count = 0;
        int ptr = -1;

        for (int i = 0; i < b.length(); i++) {
            int ans = search(idx[b.charAt(i) - 'a'], ptr);
            if (ans > ptr) {
                count = count + (ans - ptr);
                ptr = ans;
            } else if (ans != -1) {
                count = count + (a.length() - ptr + ans);
                ptr = ans;
            } else
                return -1;
        }

        return count;
    }
}

class Q2 {
    public boolean union(int i, int j, int[] rank, int[] par) {
        i = getPar(i, par);
        j = getPar(j, par);

        if (i == j)
            return false;

        if (rank[i] > rank[j]) {
            par[j] = i;
            rank[i] += rank[j];
        } else {
            par[i] = j;
            rank[j] += rank[i];
        }

        return true;
    }

    public int getPar(int i, int[] par) {
        if (par[i] == -1)
            return i;
        return par[i] = getPar(par[i], par);
    }

    static class Pair {
        int i, j;
        long dist;

        Pair(int i, int j, long dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static class Distance implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return (int) (a.dist - b.dist);
        }
    }

    long solution(int n, int[][] locations) {
        ArrayList<Pair> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long x = Math.abs((long) locations[i][0] - locations[j][0]);
                long y = Math.abs((long) locations[i][1] - locations[j][1]);
                long z = Math.abs((long) locations[i][2] - locations[j][2]);
                edges.add(new Pair(i, j, Math.min(x, Math.min(y, z))));
            }
        }

        Collections.sort(edges, new Distance());

        int[] rank = new int[n + 1];
        int[] par = new int[n + 1];
        Arrays.fill(par, -1);

        long ans = 0;
        for (Pair edge : edges) {
            if (union(edge.i, edge.j, rank, par) == true) {
                ans = ans + edge.dist;
            }
        }
        return ans;
    }

}