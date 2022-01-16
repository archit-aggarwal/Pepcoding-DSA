class Solution {
public:
    int maxWidthRamp(vector<int>& arr) 
    {
        int n = arr.size();
        int rmax[n];
        rmax[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--)
            rmax[i] = max(arr[i], rmax[i+1]);
            
        int i = 0, j = 0;
        int ans = 0;
        while(i < n && j < n)
        {
            if(arr[i] <= rmax[j])
            {
                ans = max(ans, j - i);
                j++;
            }
            else i++;
        }
        return ans;
    }
};