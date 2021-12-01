// 1219. Path with Maximum Gold (Gold Mine)
class Solution {
    int[] x = {+1, -1, 0, 0};
    int[] y = {0, 0, +1, -1};
    
    public int DFS(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
          || grid[r][c] == 0 || grid[r][c] == -1){
            return 0;
        }    
        
        int val = grid[r][c];
        grid[r][c] = -1; // visited mark
        
        int maxGold = 0;
        for(int i=0; i<4; i++){
            maxGold = Math.max(maxGold, DFS(r + x[i], c + y[i], grid));
        }
        
        grid[r][c] = val;
        return maxGold + grid[r][c];
    }
    
    public int getMaximumGold(int[][] grid) {
        
        int maxGold = 0;
        // DFS Starting from every node as source node
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int currentAns = DFS(i, j, grid);
                maxGold = Math.max(maxGold, currentAns);
            }
        }
        
        return maxGold;
    }
}
