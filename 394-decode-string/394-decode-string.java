class Solution {
    
    int idx = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder("");
        int count = 0;
        
        while(idx < s.length() && s.charAt(idx) != ']'){
            char ch = s.charAt(idx);
            idx++;
            
            if(ch >= '0' && ch <= '9'){
                count = count * 10 + (ch - '0');
            } else if(ch == '[') {
                
                String chotares = decodeString(s);
                for(int i=0; i<count; i++){
                    res.append(chotares);
                }
                count = 0;
                
            } else {
                // characters from a to z
                res.append(ch);
            }
        }
        
        if(idx < s.length()) idx++;
        return  res.toString();
    }
}