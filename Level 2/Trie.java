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

// InterviewBit Shortest Unique Prefix
public class Solution {
    public static class Node{
        Node[] children = new Node[26];
        int prefCount = 0;
        int end = 0;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }

        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
    }

    public void insert(Node root, String word){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(root.get(ch) == null){
                root.set(ch);
            }

            root.prefCount++;
            root = root.get(ch);
        }

        root.prefCount++;
        root.end++;
    }

    public String search(Node root, String word){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(root.prefCount == 1) 
                return word.substring(0, i);

            root = root.get(ch);
        }

        return word;
    }

    public String[] prefix(String[] A) {
        Node root = new Node();
        for(String str: A){
            insert(root, str);
        }

        String[] res = new String[A.length];
        for(int i=0; i<res.length; i++){
            res[i] = search(root, A[i]);
        }
        return res;
    }
}

// Leetcode 14
class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        boolean isTerminal = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }
    
    public void insert(Node curr, String word) {
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.set(ch);
            
            curr = curr.get(ch);
        }
        curr.isTerminal = true;
    }
    
    String res = "";
    public void DFS(Node curr, String ans){
        int count = 0;
        
        if(ans.length() > res.length()){
            res = ans;    
        }
        
        if(curr.isTerminal == true){
            return;
        }
        
        char child = 'a';
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(curr.contains(ch) == true){
                count++;
                child = ch;
            }
        }
        
        if(count == 1) DFS(curr.get(child), ans + child);    
    }
    
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for(String str: strs){
            insert(root, str);
        }
        
        DFS(root, "");
        return res;
    }
}

// Leetcode 648
class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isTerminal = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean isTerminal(){
            return isTerminal;    
        }
        
        public void setTerminal(){
            isTerminal = true;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }
    
    public void insert(Node curr, String word) {
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.add(ch);
            
            curr = curr.get(ch);
        }
        curr.setTerminal();
    }
    
    public String search(Node curr, String word){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.isTerminal() == true){
                return word.substring(0, i);    
            }
            
            if(curr.contains(ch) == false)
                return word;
            
            curr = curr.get(ch);
        }
        return word;
    }
    
    public String replaceWords(List<String> dictionary, String str) {
        Node root = new Node();
        for(String word: dictionary) 
            insert(root, word);
        
        StringBuilder res = new StringBuilder("");
        for(String word: str.split(" ")){
            if(res.length() > 0) res.append(" ");
            res.append(search(root, word));
        }
        
        return res.toString();
    }
}

// Leetcode 676
class MagicDictionary {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isTerminal = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean isTerminal(){
            return isTerminal;    
        }
        
        public void setTerminal(){
            isTerminal = true;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }

    Node root;
    public MagicDictionary() {
        root = new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word: dictionary){
            Node curr = root;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                
                if(curr.contains(ch) == false)
                    curr.add(ch);
                
                curr = curr.get(ch);
            }
            curr.setTerminal();
        }
    }
    
    public boolean search(String word, int idx, Node curr, boolean change){
        if(idx == word.length()){
            if(change == true && curr.isTerminal() == true) return true;
            return false;
        }
        
        char ch = word.charAt(idx);
        if(curr.contains(ch) == true && search(word, idx + 1, curr.get(ch), change))
            return true;
        
        if(change == true) return false;
        
        for(char chn = 'a'; chn <= 'z'; chn++){
            if(chn == ch) continue;
            
            if(curr.contains(chn) && search(word, idx + 1, curr.get(chn), true)){
                return true;
            }
        }
        return false;
    }
    
    public boolean search(String searchWord) {
        return search(searchWord, 0, root, false);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

// Leetcode 720
class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isTerminal = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean isTerminal(){
            return isTerminal;    
        }
        
        public void setTerminal(){
            isTerminal = true;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }
    
    public void insert(String word, Node curr) {
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.add(ch);
            
            curr = curr.get(ch);
        }
        curr.setTerminal();
    }
    
    String res = "";
    public void DFS(Node root, String ansSofar){
        if(root.isTerminal() == false) return;    
        
        if(ansSofar.length() > res.length())
            res = ansSofar;
        
        for(char ch ='a'; ch <= 'z'; ch++){
            if(root.contains(ch) == true){
                DFS(root.get(ch), ansSofar + ch);
            }
        }
    }
    
    public String longestWord(String[] words) {
        Node root = new Node();
        for(String word: words)
            insert(word, root);
        
        root.setTerminal();
        
        DFS(root, "");
        return res;
    }
}

// Leetcode 1268
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
    public void insert(Node root, String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    public void DFS(Node root, String ssf, List<String> ans, int k){
        if(ans.size() == k) return;
        
        if(root.getEnd() == true) {
            ans.add(ssf);
        }
        
        for(char ch='a'; ch<='z'; ch++){
            if(root.contains(ch) == true){
                DFS(root.get(ch), ssf + ch, ans, k);
            }
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for(String word: products) 
            insert(root, word);
        
        List<List<String>> res = new ArrayList<>();
        
        for(int i=0; i<searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            
            if(root.contains(ch) == true){
                root = root.get(ch);
                List<String> ans = new ArrayList<>();
                DFS(root, searchWord.substring(0, i + 1), ans, 3);
                res.add(ans);
            } else break;   
        }
        
        while(res.size() < searchWord.length()){
            res.add(new ArrayList<>());
        }
        return res;
    }
}

// leetcode 1032
class StreamChecker {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isTerminal = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean isTerminal(){
            return isTerminal;    
        }
        
        public void setTerminal(){
            isTerminal = true;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }

    
    public void insert(Node curr, String word) {
        for(int i=word.length()-1; i>=0; i--){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.add(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setTerminal();
    }
    
    Node root;
    public StreamChecker(String[] words) {
        root = new Node();
        for(String word: words)
            insert(root, word);
    }
    
    StringBuilder sb = new StringBuilder("");
    public boolean query(char letter) {
        sb.append(letter);
        
        Node curr = root;
        for(int i=sb.length()-1; i>=0; i--){
            if(curr.isTerminal() == true) return true;
            
            char ch = sb.charAt(i);
            if(curr.contains(ch) == false) return false;
            
            curr = curr.get(ch);
        }
        
        if(curr.isTerminal() == true) return true;
        return false;
    }
}
