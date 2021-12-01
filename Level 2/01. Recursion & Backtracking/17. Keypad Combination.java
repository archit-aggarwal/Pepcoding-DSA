class Solution {
    List<String> res;
    
    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void letterCombinations(int idx, String input, String output){
        if(idx == input.length()){
            if(output.length() > 0){
                res.add(output);
            }
            return;
        }
        
        char digit = input.charAt(idx);
        for(char letter: keypad[digit - '0'].toCharArray()){
            letterCombinations(idx + 1, input, output + letter);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        letterCombinations(0, digits, "");
        return res;
    }
}
