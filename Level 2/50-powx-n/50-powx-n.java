class Solution {
    public double power(double x, int n){
        if(n == 0) return 1.0;
        
        double res = power(x, n/2);
        
        if(n % 2 == 0)
            return res * res; // Meeting Expectation
        else 
            return res * res * x;
    }
    
    public double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(x == 1) return 1.0;
        
        if(n < 0){
            return 1.0 / power(x, -n);
        }
        
        return power(x, n);
    }
}