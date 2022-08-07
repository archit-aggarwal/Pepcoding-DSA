import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1
// Time = O(N) where N = Number of Nodes

class Solution {
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
        int oddCount = 0;
        for (int i = 0; i < V; i++) {
            if (adj.get(i).size() % 2 == 1)
                oddCount++;
        }

        if (oddCount == 0)
            return 2; // Euler Circuit
        if (oddCount == 2)
            return 1; // Euler Path But No Euler Circuit
        return 0; // No Euler Path and No Euler Circuit
    }
}