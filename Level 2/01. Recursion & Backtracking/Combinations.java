// Boxes on Level
class Solution {
    public void combine(List<List<Integer>> combinations, 
        List<Integer> combination, int currentBox, int n, int k){
        if(currentBox == n){
            if(combination.size() == k){
                // deep copy
                List<Integer> temp = new ArrayList<>(combination);
                combinations.add(temp);
            }
            return;
        }
        
        // options -> current Box -> item should be placed or not
        
        // yes
        combination.add(currentBox + 1);
        combine(combinations, combination, currentBox + 1, n, k);
        combination.remove(combination.size() - 1);
        
        // no
        combine(combinations, combination, currentBox + 1, n, k);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combine(combinations, combination, 0, n, k);
        return combinations;
    }
}
