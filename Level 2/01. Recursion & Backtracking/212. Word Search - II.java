class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    
    public void insert(Node curr, String word) {
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    HashSet<String> res;
    
    public void exist(int r, int c,  char[][] board, String ssof, Node root){ 
        if(root == null) return;
        
        if(root.getEnd() == true){
            // if word exists in dictionary or not
            res.add(ssof);
        }
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length 
           || board[r][c] == '0')
            return;
        
        for(int call=0; call<4; call++){
            char ch = board[r][c];
            board[r][c] = '0';
            exist(r + x[call], c + y[call], board, ssof + ch, root.get(ch));
            board[r][c] = ch;
        }    
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        
        Node root = new Node();
        for(String word: words){
            // insert in trie
            insert(root, word);
        }
            
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                exist(i, j, board, "", root);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(String str: res){
            ans.add(str);
        }
        return ans;
    }
}
