class Solution {
public:
    struct trie
    {
        trie *left = nullptr;
        trie *right = nullptr;
        int count = 0;
    };
    
    void insert(trie *root, int x)
    {
        for(int i=31; i>=0; i--)
        {
            if((x >> i) & 1)
            {
                if(!root->right)
                    root->right = new trie;
                root = root->right;
            }
            else
            {
                if(!root->left)
                    root->left = new trie;
                root = root->left;
            }
            root->count++;
        }
    }

    int find(trie *root , int x, int k)
    {
        int ans = 0;
        for(int i=31; i>=0; i--)
        {
            int xdig = (x >> i) & 1;
            int kdig = (k >> i) & 1;
            if(kdig)
            {
                if(xdig)
                {
                    if(root->right)
                        ans = ans + root->right->count;
                    
                    if(root->left)
                        root = root->left;
                    else return ans;
                }
                
                if(xdig == 0)
                {
                    if(root->left)
                        ans = ans + root->left->count;
                    
                    if(root->right)
                        root = root->right;
                    else return ans;
                }   
            }
            else
            {
                if(xdig == 0 && root->left)
                    root = root->left;
                else if(xdig && root->right)
                    root = root->right;
                else return ans;
                    
            }
        }
        return ans;
    }
    
    int countPairs(vector<int>& nums, int low, int high) {
        trie* root = new trie;
        
        int ans = 0;
        for(auto &x: nums)
        {
            ans += (find(root, x, high + 1) - find(root, x, low));
            insert(root, x);
        }
        
        return ans;
    }
};