class MapSum {
    public static class Node{
        private Node[] links = new Node[26];
        private int isEnd = 0;
 
        public Node get(char ch){
            return links[ch - 'a'];
        }
 
        public void add(char ch){
            Node newNode = new Node();
            links[ch - 'a'] = newNode;
        }
 
        public int getEnd(){
            return isEnd;
        }
 
        public void setEnd(int val){
            isEnd = val;
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
            Node child = curr.get(ch);
            if(child == null) curr.add(ch);
            curr = curr.get(ch);
        }
        curr.setEnd(val);
    }
    
    public int dfs(Node curr){
        if(curr == null) return 0;
        
        int sum = curr.getEnd();
        for(char ch = 'a'; ch <= 'z'; ch++){
            sum += dfs(curr.get(ch));
        }
        
        return sum;
    }
    
    public int sum(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.get(ch);
            if(child == null) return 0;
            curr = curr.get(ch);
        }
        return dfs(curr);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */