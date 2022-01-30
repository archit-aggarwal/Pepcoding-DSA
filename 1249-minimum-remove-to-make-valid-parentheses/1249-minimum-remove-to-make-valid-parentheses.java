class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                q.addLast(i);
            } else if(ch == ')'){
                if(q.size() == 0 || s.charAt(q.getLast()) == ')')
                   q.addLast(i);
                else q.removeLast();
            }
        }
        
        StringBuilder res = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            if(q.size() > 0 && q.getFirst() == i){
                q.removeFirst();
                continue;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}