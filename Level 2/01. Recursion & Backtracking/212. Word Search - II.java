// This solution will give TLE. Implement Trie (Prefix Tree) for ACCEPTED verdict.
class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    HashSet<String> dict;
    List<String> res;
    int maxLengthWord = 0;
    
    public void exist(int r, int c,  char[][] board, String ssof){
        if(ssof.length() > maxLengthWord) return;
        
        if(dict.contains(ssof)) 
        {
            dict.remove(ssof);
            res.add(ssof);
        }
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length 
           || board[r][c] == '0')
            return;
        
        
        for(int call=0; call<4; call++){
            char ch = board[r][c];
            board[r][c] = '0';
            exist(r + x[call], c + y[call], board, ssof + ch);
            board[r][c] = ch;
        }    
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        dict = new HashSet<>();
        
        maxLengthWord = 0;
        for(String word: words){
            maxLengthWord = Math.max(word.length(), maxLengthWord);
            dict.add(word);
        }
            
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                exist(i, j, board, "");
            }
        }
        return res;
    }
}
