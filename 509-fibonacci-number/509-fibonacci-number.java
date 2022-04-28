class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        int first = 0, second = 1, third = first + second;
        for(int count=3; count<=n; count++){
            first = second;
            second = third;
            third = first + second;
        }
        return third;
    }
}