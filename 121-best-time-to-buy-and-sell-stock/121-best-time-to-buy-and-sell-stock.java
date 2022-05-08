class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int selling = prices[n - 1], profit = 0;
        
        for(int i=n-1; i>=0; i--){
            selling = Math.max(selling, prices[i]);
            
            int buying = prices[i]; // Today - Potential Buying Day
            
            profit = Math.max(profit, selling - buying);
        }
        
        return profit;
    }
}