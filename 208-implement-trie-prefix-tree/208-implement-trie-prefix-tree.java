class Trie {
    public static class Node{
        private Node[] links = new Node[26];
        private boolean isEnd = false;
        
        public Node get(char ch){
            return links[ch - 'a'];
        }
        
        public void add(char ch){
            Node newNode = new Node();
            links[ch - 'a'] = newNode;
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) curr.add(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) return false;
            curr = curr.get(ch);
        }
        return curr.getEnd();
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) return false;
            curr = curr.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */