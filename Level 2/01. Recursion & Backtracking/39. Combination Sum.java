// Coin Change - Combinations - Infinite Supply
class Solution {
    List<List<Integer>> res;
    
    public void combinations(List<Integer> ans, int[] uniqueCoins, int currentCoin, int target){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(currentCoin == uniqueCoins.length){
            return;
        }
        
        int val = uniqueCoins[currentCoin];
        
        for(int i=0; target - i * val >= 0; i++) {
            for(int j=1; j<=i; j++){
                ans.add(val);
            }

            combinations(ans, uniqueCoins, currentCoin + 1, target - i * val);

            for(int j=1; j<=i; j++){
                ans.remove(ans.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        combinations(new ArrayList<>(), candidates, 0, target);
        return res;
    }
}
