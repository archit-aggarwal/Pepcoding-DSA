// Combinations - Box on Level/ Box Chooses
class Solution {
static List<List<String>> res;

    public static boolean isQueenSafe(int r, int c, boolean[][] vis){
        // row (left)
        for(int j=0; j<c; j++){
            if(vis[r][j] == true)
                return false;
        }
        // col (up)
        for(int i=0; i<r; i++){
            if(vis[i][c] == true)
                return false;
        }

        // left diagnol (up)
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(vis[i][j] == true){
                return false;
            }
            i--; j--;
        }

        // right diagnol (down)
        i = r; j = c;
        while(j < vis.length && i >= 0){
            if(vis[i][j] == true){
                return false;
            }
            i--; j++;
        }

        return true;
    }

    public static void nqueen(int r, int c, int qpsf, boolean[][] vis) {
        if (qpsf == vis.length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < vis.length; i++) {
                String curr = "";
                for (int j = 0; j < vis.length; j++) {
                    if (vis[i][j] == true) {
                        curr = curr + "Q";
                    } else {
                        curr = curr + ".";
                    }
                }
                ans.add(curr);
            }
            res.add(ans);
            return;
        }
        if(r == vis.length){
            return;
        }

        if (isQueenSafe(r, c, vis)) {
            vis[r][c] = true;

            if (c == vis.length - 1) {
                nqueen(r + 1, 0, qpsf + 1, vis);
            } else {
                nqueen(r, c + 1, qpsf + 1, vis);
            }

            vis[r][c] = false;
        }

        if (c == vis.length - 1) {
            nqueen(r + 1, 0, qpsf, vis);
        } else {
            nqueen(r, c + 1, qpsf, vis);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];

        nqueen(0, 0, 0, vis);
        return res;
        
    }
}



// Backtracking - Row on Level - Queen Chooses
class Solution {
    static List<List<String>> res;
    public static boolean isQueenSafe(int r, int c, boolean[][] vis){
        // col (up)
        for(int i=0; i<r; i++){
            if(vis[i][c] == true)
                return false;
        }

        // left diagnol (up)
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(vis[i][j] == true){
                return false;
            }
            i--; j--;
        }

        // right diagnol (down)
        i = r; j = c;
        while(j < vis.length && i >= 0){
            if(vis[i][j] == true){
                return false;
            }
            i--; j++;
        }

        return true;
    }

    public static void nqueen(int r, boolean[][] vis) {
        if (r == vis.length) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < vis.length; i++) {
                String curr = "";
                for (int j = 0; j < vis.length; j++) {
                    if (vis[i][j] == true) {
                        curr = curr + "Q";
                    } else {
                        curr = curr + ".";
                    }
                }
                ans.add(curr);
            }
            res.add(ans);
            return;
        }

        
        for(int c=0; c<vis.length; c++){
            if(isQueenSafe(r, c, vis)){
                vis[r][c] = true;
                nqueen(r + 1, vis);
                vis[r][c] = false;
            }
        }    
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];

        nqueen(0, vis);
        return res;
        
    }
}



// Branch & Bound - Visited Boolean Arrays
class Solution {
    static List<List<String>> res;
    
    public static boolean isQueenSafe(int r, int c, boolean[] ld, boolean[] rd, boolean[] col){
        int n = col.length;
        return ((ld[r - c + n - 1] == true) || (rd[r + c] == true) || (col[c] == true)) ? false : true;
    }

    public static void nqueen(int r, boolean[][] chess, boolean[] ld, boolean[] rd, boolean[] col) {
        int n = chess.length;
        if (r == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String curr = "";
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == true) {
                        curr = curr + "Q";
                    } else {
                        curr = curr + ".";
                    }
                }
                ans.add(curr);
            }
            res.add(ans);
            return;
        }

        
        for(int c=0; c<n; c++){
            if(isQueenSafe(r, c, ld, rd, col)){
                chess[r][c] = ld[r - c + n - 1] = rd[r + c] = col[c] = true;
                nqueen(r + 1, chess, ld, rd, col);
                chess[r][c] = ld[r - c + n - 1] = rd[r + c] = col[c] = false;
            }
        }    
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] chess = new boolean[n][n];
        boolean[] leftDiagnol = new boolean[2 * n - 1];
        boolean[] rightDiagnol = new boolean[2 * n - 1];
        boolean[] column = new boolean[n];
        
        nqueen(0, chess, leftDiagnol, rightDiagnol, column);
        return res;
        
    }
}

// Bit Manipulation - Using BitSet Library 
import java.util.BitSet;

class Solution {
    static List<List<String>> res;
    
    public static boolean isQueenSafe(int r, int c, int n, BitSet ld, BitSet rd, BitSet col){
        return ((ld.get(r - c + n - 1) == true) || (rd.get(r + c) == true) || (col.get(c) == true)) ? false : true;
    }

    public static void nqueen(int r, boolean[][] chess, BitSet ld, BitSet rd, BitSet col) {
        int n = chess.length;
        if (r == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String curr = "";
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == true) {
                        curr = curr + "Q";
                    } else {
                        curr = curr + ".";
                    }
                }
                ans.add(curr);
            }
            res.add(ans);
            return;
        }

        
        for(int c=0; c<n; c++){
            if(isQueenSafe(r, c, n, ld, rd, col)){
                chess[r][c] = true;
                ld.set(r - c + n - 1, true);
                rd.set(r + c, true);
                col.set(c, true);
                
                nqueen(r + 1, chess, ld, rd, col);
                ld.set(r - c + n - 1, false);
                rd.set(r + c, false);
                col.set(c, false);
                chess[r][c] = false;
            }
        }    
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] chess = new boolean[n][n];
        BitSet leftDiagnol = new BitSet(2 * n - 1);
        BitSet rightDiagnol = new BitSet(2 * n - 1);
        BitSet column = new BitSet(n);
        
        nqueen(0, chess, leftDiagnol, rightDiagnol, column);
        return res;
        
    }
}
