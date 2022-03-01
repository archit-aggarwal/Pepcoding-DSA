class Solution {
    public static class Pair implements Comparable<Pair>{
        int row, col, val;
        
        public Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
        public int compareTo(Pair other){
            return (this.val - other.val);
        }
    }
    
    int[] rows = {-1, 1, 0, 0};
    int[] cols = {0, 0, 1, -1};
    
    public int trapRainWater(int[][] mat) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int row = mat.length, col = mat[0].length;
        
        for(int i=0; i<row; i++){
            if(mat[i][0] != -1){
                q.add(new Pair(i, 0, mat[i][0]));
                mat[i][0] = -1;
            }
            
            if(mat[i][col - 1] != -1){
                q.add(new Pair(i, col - 1, mat[i][col - 1]));    
                mat[i][col - 1] = -1;
            }
        }
                   
        for(int j=0; j<col; j++){
            if(mat[0][j] != -1){
                q.add(new Pair(0, j, mat[0][j]));
                mat[0][j] = -1;
            }
            
            if(mat[row - 1][j] != -1){
                q.add(new Pair(row - 1, j, mat[row - 1][j]));
                mat[row - 1][j] = -1;
            }
        }
        
        int water = 0;
        while(q.size() > 0){
            Pair min = q.remove();
            
            for(int i=0; i<4; i++){
                int r = min.row + rows[i];
                int c = min.col + cols[i];
                
                if(r >= 0 && r < row && c >= 0 && c < col && mat[r][c] != -1){
                    int newVal = mat[r][c];

                    if(newVal < min.val){
                        water += (min.val - newVal);
                        q.add(new Pair(r, c, min.val));
                    }
                    else q.add(new Pair(r, c, newVal));
                    mat[r][c]  = -1;
                }
            }
        }
        return water;
    }
}