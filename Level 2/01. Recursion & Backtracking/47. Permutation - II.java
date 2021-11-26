class Solution {
    List<List<Integer>> res;
    
    // Box On Level : Method 1 
    public void permutations1(HashMap<Integer, Integer> freq, int[] nums,
            int currentBox, List<Integer> ans){
        if(currentBox == nums.length){
            List<Integer> copy = new ArrayList<>(ans);
            res.add(copy);
            return;
        }
        
        for(Integer key: freq.keySet()){
            int val = freq.get(key);
            if(val > 0){
               freq.put(key, val - 1);
               ans.add(key); 
                
               permutations1(freq, nums, currentBox + 1, ans); 
               
               ans.remove(ans.size() - 1);
               freq.put(key, val);
            }
        }
    }
    
    // Method 2: Item on Level
    public void permutations2(HashMap<Integer, Integer> lastIdx, int[] nums, 
            int currentItem, List<Integer> ans){
        if(currentItem == nums.length){
            List<Integer> copy = new ArrayList<>(ans);
            res.add(copy);
            return;
        }
        
        int st = lastIdx.get(nums[currentItem]);
        
        for(int i=st+1; i<ans.size(); i++){
            if(ans.get(i) == null){
                ans.set(i, nums[currentItem]);
                lastIdx.put(nums[currentItem], i);
                
                permutations2(lastIdx, nums, currentItem + 1, ans);
                
                lastIdx.put(nums[currentItem], st);
                ans.set(i, null);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     if(freq.containsKey(nums[i])){
        //         int val = freq.get(nums[i]);
        //         freq.put(nums[i], val + 1);
        //     } else {
        //         freq.put(nums[i], 1);
        //     }
        // }
        // res = new ArrayList<>();
        // permutations1(freq, nums, 0, new ArrayList<>());
        
        HashMap<Integer, Integer> lastIdx = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            lastIdx.put(nums[i], -1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            ans.add(null);
        }
        
        res = new ArrayList<>();
        permutations2(lastIdx, nums, 0, ans);
        return res;
    }
}
