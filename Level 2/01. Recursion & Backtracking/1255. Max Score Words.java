class Solution {
    
    public int maxScore(int idx, String[] words, int[] freq, int[] score){
        if(idx == words.length) return 0;
        
        // yes
        int currScore = 0;
        int lastIdx = -1;
        for(int i=0; i<words[idx].length(); i++){
            char ch = words[idx].charAt(i);
            
            freq[ch - 'a']--;
            if(freq[ch - 'a'] < 0){
                lastIdx = i;
                break;
            }
            
            currScore += score[ch - 'a'];
        }
        
        if(lastIdx == -1){
            currScore += maxScore(idx + 1, words, freq, score);    
            for(int i=0; i<words[idx].length(); i++){
                freq[words[idx].charAt(i) - 'a']++;
            }
        } else {
            // backtrack
           for(int i=0; i<=lastIdx; i++){
               char ch = words[idx].charAt(i);
               freq[ch - 'a']++;
           }    
           currScore = 0;
        }
        
        
        
        // no
        return Math.max(currScore, maxScore(idx + 1, words, freq, score));
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(char ch: letters) freq[ch - 'a']++;
        return maxScore(0, words, freq, score);
    }
}
