// Distinct Subsets Permutations
class Solution {
public:
    int res = 0;
    void helper(string &nums, unordered_map<char, int> &freq, int box)
    {
        if(box == nums.size())
            return;
        
        for(auto &p: freq)
        {
            if(p.second > 0)
            {
                nums[box] = p.first;
                p.second--;
                res++;
                
                helper(nums, freq, box + 1);
                
                p.second++;
                nums[box] = 0;
            }
        }
    }
    
    int numTilePossibilities(string nums) {
        unordered_map<char, int> freq;
        for(int i=0; i<nums.size(); i++) 
        {
            freq[nums[i]]++;
            nums[i] = 0;
        }
        
        helper(nums, freq, 0);
        return res;       
    }
};
