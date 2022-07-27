import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
// Time - Exponential (Backtracking Solution Similar to N Queen)

class solve {
    public boolean canColor(int src, boolean graph[][], int color, int[] vis) {
        // If any neighbour have same color as my color, hence it cannot happen
        for (int nbr = 0; nbr < graph.length; nbr++) {
            if (graph[src][nbr] == true && vis[nbr] == color)
                return false;
        }
        return true;
    }

    public boolean helper(int idx, boolean graph[][], int color, int[] vis) {
        if (idx == graph.length)
            return true;

        for (int c = 0; c < color; c++) {
            if (canColor(idx, graph, c, vis) == true) {
                vis[idx] = c;
                if (helper(idx + 1, graph, color, vis) == true)
                    return true;
                vis[idx] = -1;
            }
        }

        return false;
    }

    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        return helper(0, graph, m, vis);
    }
}