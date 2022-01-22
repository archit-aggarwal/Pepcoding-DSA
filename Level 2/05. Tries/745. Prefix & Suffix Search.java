class WordFilter {
    public static class Node{
        private Node[] children = new Node[27];
        int idx = -1;
        
        public boolean contains(char ch){
            if(ch == '#') return children[26] != null;
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            if(ch == '#') return children[26];
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            if(ch == '#') children[26] = new Node();
            else children[ch - 'a'] = new Node();
        }
    }
    
    Node root;
    WordFilter(String[] words){
        root = new Node();
        
        for(int idx=0; idx<words.length; idx++){
            String word = words[idx];
            
            for(int i=0; i<word.length(); i++){
                // System.out.println(word.substring(i) + "#" + word.substring(0, i));
                insert(root, word.substring(i) + "#" + word, idx);
            }
            
            insert(root, "#" + word, idx);
        }
    }
    
    public void insert(Node root, String word, int idx) {
        Node curr = root;
        root.idx = idx;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
            curr.idx = idx;
        }
    }
    
    public int search(Node root, String word) {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return -1;
        
            curr = curr.get(ch);
        }
        
        return curr.idx;
    }
    
    public int f(String prefix, String suffix) {
        return search(root, suffix + "#" + prefix);
    }
}
