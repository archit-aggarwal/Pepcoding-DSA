class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    
    public boolean exist(int r, int c, int idx, char[][] board, String word){
        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;
        if(board[r][c] != word.charAt(idx)) return false;
        
        for(int call=0; call<4; call++){
            char ch = board[r][c];
            board[r][c] = '0';
            
            boolean res = exist(r + x[call], c + y[call], idx + 1, board, word);
            
            board[r][c] = ch;
            if(res == true) return true;
        }    
        
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(i, j, 0, board, word) == true)
                    return true;
            }
        }
        return false;
    }
}
