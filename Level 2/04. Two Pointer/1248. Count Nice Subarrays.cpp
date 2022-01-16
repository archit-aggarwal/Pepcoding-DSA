class Solution {
public:
    long long helper(vector<int> &nums,int k)
    {
        long long left = 0, right = 0;
        long long res = 0, odd = 0;
        for(right = 0; right < nums.size(); right++)
        {
            if(nums[right] % 2 == 1) odd++;
            if(odd <= k)
            {
                res += right - left + 1;
                continue;
            }
            while(left <= right && odd > k)
            {
                if(nums[left] % 2 == 1)
                {
                    left++;
                    odd--;
                    res += right - left + 1;
                    break;
                }
                left++;
            }
        }
        return res;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
};