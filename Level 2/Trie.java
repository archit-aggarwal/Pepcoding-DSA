// Leetcode 208
class Trie {
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
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return false;
        
            curr = curr.get(ch);
        }
        
        return curr.getEnd();
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return false;
        
            curr = curr.get(ch);
        }
        
        return true;
    }
}

// Leetcode 211
class WordDictionary {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean getEnd(){
            return isEnd;    
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
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
            
            if(curr.contains(ch) == false)
                curr.add(ch);
            
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word, int idx, Node curr){
        if(idx == word.length()){
            return curr.getEnd();
        }
        
        char ch = word.charAt(idx);
        
        if(ch != '.'){
            if(curr.contains(ch) == false) return false;
            return search(word, idx + 1, curr.get(ch));
        }
        
        for(char chn = 'a'; chn <= 'z'; chn++){
            if(curr.contains(chn) == false) continue;
            
            if(search(word, idx + 1, curr.get(chn))) 
                return true;
        }
        
        return false;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

// Leetcode 1804
public class Trie {
    public static class Node{
        private Node[] children = new Node[26];
        private int isEnd = 0;
        private int prefixCount = 0;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public int getFreq(){
            return isEnd;
        }
        
        public int getPref(){
        	return prefixCount;    
        }
        
        public void increaseFreq(){
            isEnd++;
        }
        
        public void decreaseFreq(){
            isEnd--;
        }
        
        public void increasePref(){
            prefixCount++;
        }
        
        public void decreasePref(){
            prefixCount--;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            curr.increasePref();
            
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.increasePref();
        curr.increaseFreq();
    }

    public int countWordsEqualTo(String word) {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return 0;
        
            curr = curr.get(ch);
        }
        
        return curr.getFreq();
    }

    public int countWordsStartingWith(String word) {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                return 0;
        
            curr = curr.get(ch);
        }
        
        return curr.getPref();
    }

    public void erase(String word) {
        if(countWordsEqualTo(word) == 0){
            return;
        }
        
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            curr.decreasePref();
            char ch = word.charAt(i);
            curr = curr.get(ch);
        }
        
        curr.decreasePref();
        curr.decreaseFreq();
    }

}

// Leetcode 677
class MapSum {
    public static class Node{
        private Node[] children = new Node[26];
        private int val = 0;
        public int pref = 0;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public int getVal(){
            return val;    
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public void setVal(int val){
            this.val = val;
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }
    
    Node root;
    public MapSum() {
        root = new Node();
    }
    
    public int search(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                return 0;
            
            curr = curr.get(ch);
        }
        return curr.getVal();
    }
    
    public void insert(String word, int val) {
        int oldVal = search(word);
        
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            curr.pref += (val - oldVal);
            
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.add(ch);
                
            curr = curr.get(ch);
        }
        
        curr.pref += (val - oldVal);
        curr.setVal(val);
    }
    
    public int sum(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                return 0;
            
            curr = curr.get(ch);
        }
        return curr.pref;
    }
}

 
// Leetcode 677 (Using DFS)
class MapSum {
    public static class Node{
        private Node[] children = new Node[26];
        private int val = 0;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public int getVal(){
            return val;    
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public void setVal(int val){
            this.val = val;
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }
    
    Node root;
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String word, int val) {
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.add(ch);
                
            curr = curr.get(ch);
        }
        
        curr.setVal(val);
    }
    
    public int DFS(Node curr){
        int ans = 0;
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(curr.contains(ch) == true){
                ans += DFS(curr.get(ch));
            }
        }
        return ans + curr.getVal(); 
    }
    public int sum(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                return 0;
            
            curr = curr.get(ch);
        }
        return DFS(curr);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
