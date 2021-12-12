#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    // This is variation to Book Allocation. Here Each Student 
    // must have to read exactly k number of books.

    bool isPossible(vector<int> &nums, int mid, int m, int k)
    {
        long long int curr = 0;
        int i = 0;
        while(curr < m && i < nums.size())
        {
            long long count = 0;
            while(count < k && i + count < nums.size())
            {
                if(nums[i + count] > mid)
                    break;
                count++;
            }
            if(count == k)
            {
                curr++;
                i = i + k;
            }
            else i = i + count + 1;
        }
        
        return (curr >= m); // Here condition is different, we need atleast
        // m no of subarrays of size k each with all elements <= mid
    }
    
    int minDays(vector<int>& nums, int m, int k) 
    {
        if(m * k > nums.size()) return -1; 
        // Not Possible to distribute k flowers/books to each m bouquets/students
        
        long long int low = 1e18, high = 0;
        for(auto &i: nums) 
        {
            low = min(low, (long long)i);
            high += i;
        }

        long long int ans = high;
        while(low <= high)
        {
            long long int mid = low + (high - low)/2ll;
            if(isPossible(nums, mid, m, k))
            {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
};