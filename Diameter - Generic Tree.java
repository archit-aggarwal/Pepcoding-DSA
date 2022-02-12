public class Solution {
    public int globalDia = 0;

    public int dfs(ArrayList<Integer>[] adj, int root){
        int maxHeight = 0, secondMaxHeight = 0;
        for(Integer child: adj[root]){
            int height = dfs(adj, child);
            if(height > maxHeight){
                secondMaxHeight = maxHeight;
                maxHeight = height;
            }
            else if(height >= secondMaxHeight) 
                secondMaxHeight = height;
        }

        globalDia = Math.max(globalDia, maxHeight + secondMaxHeight + 1);
        return 1 + maxHeight;
    }

    public int solve(int[] A) {
        ArrayList<Integer>[] adj = new ArrayList[A.length];
        for(int i=0; i<A.length; i++){
            adj[i] = new ArrayList<>();
        }

        int root = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == -1) root = i;
            else adj[A[i]].add(i);
        }

        dfs(adj, root);
        return globalDia - 1;
    }
}
