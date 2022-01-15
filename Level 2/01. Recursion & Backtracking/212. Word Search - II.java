class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    List<String> res;
    
    public void exist(int r, int c,  char[][] board, String ssof){    
        if(){
            // if word exists in dictionary or not
        }
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length 
           || board[r][c] == '0')
            return;
        
        if(){
            // if word is a prefix of another word or not    
        }
        
        for(int call=0; call<4; call++){
            char ch = board[r][c];
            board[r][c] = '0';
            exist(r + x[call], c + y[call], board, ssof + ch);
            board[r][c] = ch;
        }    
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        
        for(String word: words){
            // insert in trie
        }
            
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                exist(i, j, board, "");
            }
        }
        return res;
    }
}
