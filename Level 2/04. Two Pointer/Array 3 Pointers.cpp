int Solution::minimize(const vector<int> &A, const vector<int> &B, const vector<int> &C) {
    int i = 0, j = 0, k = 0;
    int ans = INT_MAX;
    while(i < A.size() && j < B.size() && k < C.size())
    {
        int a = abs(A[i] - B[j]), b = abs(B[j] - C[k]), c = abs(C[k] - A[i]);
        ans = min(ans, max(a, max(b, c)));
        if(A[i] <= B[j] && A[i] <= C[k])
            i++;
        else if(B[j] <= C[k] && B[j] <= A[i])
            j++;
        else k++;
    }
    return ans;
}
