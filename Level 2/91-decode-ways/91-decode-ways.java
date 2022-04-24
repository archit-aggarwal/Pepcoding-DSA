class Solution {
    public int memo(String s, int idx, int[] dp){
        if(idx == s.length()) return 1;
        if(dp[idx] != -1) return dp[idx];
        
        int ans1 = 0, ans2 = 0;
        if(s.charAt(idx) != '0'){
            ans1 = memo(s, idx + 1, dp);
        }
        
        
        if(idx + 1 < s.length() && s.charAt(idx) != '0'){
            int code = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(code >= 10 && code <= 26){
                ans2 = memo(s, idx + 2, dp);
            }
        }
        
        return dp[idx] = ans1 + ans2;
    }
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return memo(s, 0, dp);
    }
}