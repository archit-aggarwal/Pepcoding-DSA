class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        
        for(int i=1; i<prices.length; i++){
            
            // Treat today as Buying Day
            int newBuy = Math.max(buy, sell - prices[i]);
            
            // Treat today as Selling Day
            int newSell = Math.max(sell, buy + prices[i] - fee);
            
            buy = newBuy; sell = newSell;
        }
        
        return sell;
    }
}