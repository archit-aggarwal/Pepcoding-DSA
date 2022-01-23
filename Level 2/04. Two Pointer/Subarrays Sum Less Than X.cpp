// Write Your Code Here
int Solution::solve(vector<int> &nums, int k) {
    long long int sum = 0ll, ans = 0, left = 0;
    for (int right = 0; right < nums.size(); right++) {
        sum += nums[right];
        while (sum >= k) sum -= nums[left++];
        ans += right - left + 1ll;
    }
    return ans;
}
