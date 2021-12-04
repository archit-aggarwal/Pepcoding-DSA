// Method - 1
class Solution {
    List<Integer> res;
    
    public void lexicalOrder(int input, int n){
        if(input > n) return;
        
        res.add(input);
        for(int i=0; i<10; i++){
            lexicalOrder(input * 10 + i, n);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int i=1; i<10; i++){
            lexicalOrder(i, n);
        }
        return res;
    }
}

// Method - 2
class Solution {
    List<Integer> res;
    public void lexicalOrder(int input, int n){
        if(input > n) return;
        if(input != 0) res.add(input);
      
        for(int i=0; i<10; i++){
            if(i > 0 || input > 0)
                lexicalOrder(input * 10 + i, n);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        lexicalOrder(0, n);
        return res;
    }
}
