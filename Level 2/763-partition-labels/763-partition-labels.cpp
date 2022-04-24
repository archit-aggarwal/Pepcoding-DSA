class Solution {
public:
    vector<int> partitionLabels(string s) {
        int n = s.length();
        
        vector<int> vec(26,0);
        for (int i=0;i<n;i++){
            vec[s[i]-'a'] = i;
        }
        
        vector<int> res;
        int max_idx = 0;
        int l = 0;
        
        for (int i=0;i<n;i++){
            max_idx = max(max_idx,vec[s[i]-'a']);
            
            if (max_idx == i){
                res.push_back(i-l+1);
                l = i+1;
                max_idx = 0;
            }
        }
        
        return res;
    }
};