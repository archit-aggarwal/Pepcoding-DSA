class Solution {
    public String removeKdigits(String s, int removal) {
        Deque<Character> q = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            while(q.size() > 0 && removal > 0 && q.getLast() > ch){
                q.removeLast();
                removal--;
            }
            
            q.addLast(ch);
        }
        
        // removal > 0 even after entire string is traversed
        while(q.size() > 0 && removal > 0){
            q.removeLast();
            removal--;
        }
        
        // remove leading zeros
        while(q.size() > 0 && q.getFirst() == '0'){
            q.removeFirst();
        }
        
        if(q.size() == 0) return "0";
        StringBuilder str = new StringBuilder("");  
        while(q.size() > 0){
            str.append(q.removeFirst());
        }
        return str.toString();
    }
}