int Solution::solve(vector<int> &arr) {
    set<int> left;
    vector<int> right(arr.size(), 0);
    for(int i=arr.size()-1; i>=0; i--)
        right[i] = max(((i == arr.size()-1) ? 0 : right[i+1]), arr[i]);
    
    
    left.insert(INT_MIN);
    int ans = 0;
    for(int i=1; i<arr.size()-1; i++)
    {
        left.insert(arr[i-1]);
        if(arr[i] < right[i+1])
        {
            auto idx = left.lower_bound(arr[i]);
            idx--;
            ans = max(ans, right[i+1] + (*idx) + arr[i]);
        }
    }
    
    return ans;
}
