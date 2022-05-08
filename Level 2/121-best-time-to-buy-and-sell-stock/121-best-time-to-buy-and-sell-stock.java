class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int buying = prices[0], profit = 0;
        
        for(int i=0; i<n; i++){
            buying = Math.min(buying, prices[i]);
            
            int selling = prices[i]; // Today - Potential Selling Day
            
            profit = Math.max(profit, selling - buying);
        }
        
        return profit;
    }
}