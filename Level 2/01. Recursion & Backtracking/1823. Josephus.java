class Solution {
    public int josephus(int n, int k){
        if(n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }
    public int findTheWinner(int n, int k) {
        int ans = josephus(n, k);
        return ans + 1;
    }
}
