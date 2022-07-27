import java.util.*;

// Leetcode 127: https://leetcode.com/problems/word-ladder/
// Time = O(N ^ 2) Graph Formation + O(N + E) BFS

class Solution {
    public static class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public boolean isEdge(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        if (count == 1)
            return true; // Exactly One Different Character
        return false; // Self Loop or More than 1 Different Character
    }

    public int BFS(String src, String dest, HashMap<String, HashSet<String>> graph) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));

        HashMap<String, Integer> visited = new HashMap<>();
        while (q.size() > 0) {
            Pair front = q.remove();
            src = front.word;
            int level = front.level;

            if (visited.containsKey(src) == true)
                continue;
            visited.put(src, level);

            for (String nbr : graph.get(src)) {
                q.add(new Pair(nbr, level + 1));
            }
        }

        return visited.getOrDefault(dest, -1) + 1;
    }

    public int ladderLength(String src, String dest, List<String> wordList) {
        wordList.add(src);
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for (String word : wordList) {
            graph.put(word, new HashSet<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                String a = wordList.get(i), b = wordList.get(j);
                if (isEdge(a, b) == true) {
                    graph.get(a).add(b);
                    graph.get(b).add(a);
                }
            }
        }

        for (String node : graph.keySet()) {
            System.out.println(node + " " + graph.get(node));
        }
        return BFS(src, dest, graph);
    }
}