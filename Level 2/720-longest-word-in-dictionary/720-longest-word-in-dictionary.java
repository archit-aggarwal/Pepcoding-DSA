class Solution {
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
 
    
    public void addWord(Node root, String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) curr.add(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    String longestWord = "";
    public void search(Node curr, String str){
        if(curr == null || curr.getEnd() == false) 
            return;
        
        if(str.length() > longestWord.length()){
            longestWord = str;
        }
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            search(curr.get(ch), str + ch);
        }
    }
    
    public String longestWord(String[] words) {
        Node root = new Node();
        for(String word: words){
            addWord(root, word);
        }
        
        root.setEnd();
        search(root, "");
        return longestWord;
    }
}