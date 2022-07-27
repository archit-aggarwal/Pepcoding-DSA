import java.util.*;

// Leetcode 126: https://leetcode.com/problems/word-ladder-ii/
// Time: O(Exponential) in Worst Case, O(Polynomial) in Average Case

// Note: This Solution is Giving Time Limit Exceeded (TLE), Although Logic is BFS for Minimum Transformation Length + DFS for Get All Paths from Source to Destination

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

    HashMap<String, HashSet<String>> graph;
    HashMap<String, Integer> visited = new HashMap<>();

    public int BFS(String src, String dest) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));

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

        return visited.getOrDefault(dest, -1);
    }

    List<List<String>> res2d = new ArrayList<>();

    public void DFS(String src, String dest, List<String> path) {
        path.add(src);

        if (src.equals(dest) == true) {
            res2d.add(new ArrayList<>(path));
        } else {
            for (String nbr : graph.get(src)) {
                if (visited.get(nbr) == visited.get(src) + 1)
                    DFS(nbr, dest, path);
            }
        }

        path.remove(path.size() - 1);
    }

    public List<List<String>> findLadders(String src, String dest, List<String> wordList) {
        wordList.add(src);
        graph = new HashMap<>();
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

        int minLen = BFS(src, dest);
        if (minLen == -1)
            return res2d;
        DFS(src, dest, new ArrayList<String>());
        return res2d;
    }
}