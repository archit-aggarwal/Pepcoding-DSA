class Solution {
    
    int idx = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder("");
        int count = 0;
        
        while(idx < s.length() && s.charAt(idx) != ']'){
            char ch = s.charAt(idx);
            idx++;
            
            if(ch == '['){
                String temp = decodeString(s);  
                for(int c=0; c<count; c++)
                    res.append(temp);
                count = 0;
            }
            else if(ch >= '0' && ch <= '9'){
                count = (count * 10) + (ch - '0');
            } else {
                res.append(ch);
            }
        }
        
        if(idx < s.length()) idx++;
        return res.toString();
    }
}