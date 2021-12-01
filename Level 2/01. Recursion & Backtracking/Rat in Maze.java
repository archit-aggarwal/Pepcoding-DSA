// Problem Link GfG : https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

class Solution {
    static ArrayList<String> res;
    
    static int[] x = {+1, 0, 0, -1};
    static int[] y = {0, -1, +1, 0};
    static Character[] ch = {'D', 'L', 'R', 'U'};
    
    public static void findPath(int r, int c, int[][] mat, String pathSofar){
        if(r < 0 || r >= mat.length || c < 0 || c >= mat[0].length){
            // our][c] == 0 || mat[r][c] == -1){t of matrix negative base case
            return;
        }
        
        if(mat[
            // blockage node || visited cell (loop or cycle)
            return;
        }
        
        if(r == mat.length - 1 && c == mat[0].length - 1){
            // Positive Base Case
            res.add(pathSofar);
            return;
        }
        
        mat[r][c] = -1;
        for(int i=0; i<4; i++){
            findPath(r + x[i], c + y[i], mat, pathSofar + ch[i]);
        }
        mat[r][c] = 1;
    }
    
    public static ArrayList<String> findPath(int[][] mat, int n) {
        res = new ArrayList<>();
        findPath(0, 0, mat, "");
        return res;
    }
}
