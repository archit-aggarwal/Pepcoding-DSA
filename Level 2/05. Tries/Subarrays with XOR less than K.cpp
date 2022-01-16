#include<bits/stdc++.h>
using namespace std;

struct Trie
{
    long long val;
    Trie* child[2];
    Trie()
    {
        val = 0;
        child[0] = child[1] = NULL;
    }
};

void add(Trie * &root, long long n)
{
    Trie* node = root;
    for(long long i=63; i>=0; i--)
    {
        bool val = (n & (1ll << i));
        if(node->child[val] == NULL)
            node->child[val] = new Trie();
        node->val = node->val + 1ll;
        node = node->child[val];
    }
    node->val = node->val + 1ll;
}

long long findXOR(Trie* &root, long long n, long long k)
{
    Trie* node = root;
    long long ans = 0ll;
    for(long long i=63ll; i>=0ll; i--)
    {
        bool digit = (n & (1ll << i));
        bool k_digit = (k & (1ll << i));
        
        if(k_digit == false)
        {
            if(digit == false)
            {
                if(!node->child[0])
                    return ans;
                node = node->child[0];
            }
            
            else
            {
                if(!node->child[1])
                    return ans;
                node = node->child[1];
            }
            
        }
        else
        {
            if(digit)
            {
                if(node->child[1])
                    ans += node->child[1]->val;
                if(!node->child[0])
                    return ans;
                node = node->child[0];
            }
            else
            {
                if(node->child[0])
                    ans += node->child[0]->val;
                if(!node->child[1])
                    return ans;
                node = node->child[1];
            }
        }
    }
    return ans;
}
int main() 
{
    long long t; cin>>t;
    while(t--)
    {
        long long n, k; cin>>n>>k;
        long long curr = 0ll, prev = 0ll;
        long long ans = 0ll;
        Trie* root = new Trie();
        add(root, 0ll);

        for(long long i=0ll;i<n;i++)
        {
            cin >> curr;
            curr = (curr ^ prev);
            ans += findXOR(root, curr, k);
            add(root, curr);
            prev = curr;
        }
        cout << ans << endl;
    }
    return 0;
}

