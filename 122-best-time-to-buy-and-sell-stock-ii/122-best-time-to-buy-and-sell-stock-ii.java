class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int profit = 0;
        
        for(int i=0; i<prices.length; i++){
            if(stk.size() > 0 && stk.peek() < prices[i]){
                profit += prices[i] - stk.pop();
            }
            
            stk.push(prices[i]);
        }
        
        return profit;
    }
}