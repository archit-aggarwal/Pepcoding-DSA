class WordDictionary {
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
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) curr.add(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word, Node curr, int idx){
        if(curr == null) return false;
        if(idx == word.length()) return curr.getEnd();
        
        char ch = word.charAt(idx);
        
        if(ch == '.'){
            for(char chn = 'a'; chn <= 'z'; chn++){
                if(search(word, curr.get(chn), idx + 1) == true)
                    return true;
            }
            return false;
        }
        
        return search(word, curr.get(ch), idx + 1); 
    }
    
    public boolean search(String word) {
        return search(word, root, 0);    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */