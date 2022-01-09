class Solution {
    public String minWindow(String s, String t) {
        if(t.equals("") == true || s.equals("") == true || s.length() < t.length())
            return "";
        
        HashMap<Character, Integer> pattern = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
        }
        
        int matchCount = 0, left = 0, minLen = Integer.MAX_VALUE, start = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        
        for(int right=0; right < s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            
            if(window.get(ch) == pattern.getOrDefault(ch, 0)){
                matchCount++;
            }
            
            // exclude characters when string is valid
            while(matchCount == pattern.size()){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                
                char chl = s.charAt(left);
                
                if(window.get(chl) == pattern.getOrDefault(chl, 0)){
                    matchCount--;
                }
                
                left++;
                window.put(chl, window.get(chl) - 1);
            }
        }
        
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}
