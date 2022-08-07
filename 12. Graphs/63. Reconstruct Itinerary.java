import java.util.*;

// Leetcode 332: https://leetcode.com/problems/reconstruct-itinerary/
// Time = O(N + E log E)

class Solution {
    List<String> path;

    public void DFS(String src, HashMap<String, PriorityQueue<String>> adj) {
        while (adj.get(src).size() > 0) {
            String nbr = adj.get(src).remove();
            DFS(nbr, adj);
        }

        path.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);

            if (adj.containsKey(src) == false)
                adj.put(src, new PriorityQueue<>());
            if (adj.containsKey(dest) == false)
                adj.put(dest, new PriorityQueue<>());

            adj.get(src).add(dest);
        }

        path = new ArrayList<>();
        DFS("JFK", adj);
        Collections.reverse(path);
        return path;
    }
}