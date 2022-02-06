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
    
    public void insert(Node root, String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) curr.add(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public void dfs(Node curr, List<String> ans, String word){
        if(ans.size() == 3) return;
        
        if(curr.getEnd() == true)
            ans.add(word);
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(curr.get(ch) != null)
                dfs(curr.get(ch), ans, word + ch);
        }
        
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for(String word: products){
            insert(root, word);
        }
        
        List<List<String>> res = new ArrayList<>();
        Node curr = root;
        for(int i=0; i<searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            
            if(curr.get(ch) == null) break;
            
            curr = curr.get(ch);
            List<String> ans = new ArrayList<>();
            dfs(curr, ans, searchWord.substring(0, i + 1));
            res.add(ans);
        }
        
        while(res.size() < searchWord.length()){
            res.add(new ArrayList<>());
        }
        return res;
    }
}