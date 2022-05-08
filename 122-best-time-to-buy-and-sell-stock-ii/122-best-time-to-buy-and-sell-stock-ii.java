class Solution {
    public int maxProfit(int[] prices) {
        int buying = prices[0];
        int profit = 0;
        
        for(int i=0; i<prices.length; i++){
            if(buying < prices[i]){
                profit += prices[i] - buying;
            }
            
            buying = prices[i];
        }
        
        return profit;
    }
}