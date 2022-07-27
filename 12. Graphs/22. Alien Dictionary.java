import java.util.*;
// GfG: https://practice.geeksforgeeks.org/problems/alien-dictionary/1

// Time: O(N * L) Graph Formation + O(N + E) Topological Sort
// N = Number of Strings, L = String Length, E = Number of Edges = N - 1

class Solution {
    StringBuilder topo = new StringBuilder("");

    public void DFS(char src, ArrayList<Character>[] adj, boolean[] vis) {
        if (vis[src - 'a'] == true)
            return;
        vis[src - 'a'] = true;

        for (Character nbr : adj[src - 'a']) {
            DFS(nbr, adj, vis);
        }

        topo.append(src);
    }

    @SuppressWarnings("unchecked")
    public String findOrder(String[] dict, int N, int K) {
        ArrayList<Character>[] adj = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String a = dict[i], b = dict[i + 1];
            int j = 0;
            while (j < a.length() && j < b.length()) {
                if (a.charAt(j) != b.charAt(j)) {
                    adj[a.charAt(j) - 'a'].add(b.charAt(j));
                    break;
                }
                j++;
            }
        }

        boolean[] vis = new boolean[26];
        for (char ch = 'a'; ch <= 'z'; ch++)
            DFS(ch, adj, vis);
        return topo.reverse().toString();
    }
}