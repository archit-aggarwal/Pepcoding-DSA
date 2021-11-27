// Coin Change - Combination - Finite Supply
class Solution {
    List<List<Integer>> res;
    
    public void combinations(List<Integer> ans, HashMap<Integer, Integer> freq, 
                            ArrayList<Integer> uniqueCoins, int currentCoin, int target){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(currentCoin == uniqueCoins.size()){
            return;
        }
        
        int val = uniqueCoins.get(currentCoin);
        for(int i=0; i<=freq.get(val); i++) {
            if(target - i * val >= 0){
                for(int j=1; j<=i; j++){
                    ans.add(val);
                }

                combinations(ans, freq, uniqueCoins, currentCoin + 1, target - i * val);

                for(int j=1; j<=i; j++){
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> uniqueCoins = new ArrayList<>();
        for(int val: candidates){
            if(freq.containsKey(val) == false){
                freq.put(val, 1);
                uniqueCoins.add(val);
            } else {
                freq.put(val, freq.get(val) + 1);
            }
        }
        
        res = new ArrayList<>();
        combinations(new ArrayList<>(), freq, uniqueCoins, 0, target);
        return res;
    }
}
