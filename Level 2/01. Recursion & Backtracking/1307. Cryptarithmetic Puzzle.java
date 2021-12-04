class Solution {
    int[] ctod;
    // character to digit mapping
    boolean[] dtoc;
    // digit to character mapping
    
    HashSet<Character> zeros; // characters which cannot be mapped to 0
    // to prevent leading zer
        
    public long wordToNumber(String word){
        long ans = 0;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            ans = ans * 10L + ctod[ch - 'A'];
        }
        
        return ans;
    }
    
    public boolean isSolvable(int idx, ArrayList<Character> unique,
                String[] words, String result){
        
        if(idx == unique.size()){
            // equivalency check
            long left = 0L;
            for(String str: words){
                long ans = wordToNumber(str);
                left += ans;
            }
            
            long right = wordToNumber(result);
            // System.out.println(left + " " + right);
            
            if(left == right)  return true;
            return false;
        }
        
        Character ch = unique.get(idx);
        for(int i=0; i<10; i++){
            if(i > 0 || (i == 0 && zeros.contains(ch) == false)){
                if(dtoc[i] == false){
                    dtoc[i] = true;
                    ctod[ch - 'A'] = i;

                    boolean res = isSolvable(idx + 1, unique, words, result);
                    if(res == true) return true;

                    dtoc[i] = false;
                    ctod[ch - 'A'] = -1;
                }
            }
        }
        
        return false;
    }
    
    public boolean isSolvable(String[] words, String result) {
        ctod = new int[26];
        dtoc = new boolean[10];
        zeros = new HashSet<>();
        
        ArrayList<Character> unique = new ArrayList<>();
        for(String str: words){
            if(str.length() > 1) {
                zeros.add(str.charAt(0));    
            }
            
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(ctod[ch - 'A'] == 0){
                    unique.add(ch);
                    ctod[ch - 'A'] = -1;
                } 
            }
        }
        
        if(result.length() > 1){
            zeros.add(result.charAt(0));    
        }
        
        for(int i=0; i<result.length(); i++){
            char ch = result.charAt(i);
            if(ctod[ch - 'A'] == 0){
                unique.add(ch);
                ctod[ch - 'A'] = -1;
            }  
        }
        
        if(unique.size() > 10) return false;
        return isSolvable(0, unique, words, result);
    }
}
