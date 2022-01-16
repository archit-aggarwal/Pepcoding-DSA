#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends



class Solution
{
public:
    int countDistinctSubarray(int arr[], int n)
    {
        unordered_set<int> s;
        for(int i=0;i<n;i++) s.insert(arr[i]);
        unordered_map<int,int> m;
        int left = 0, ans = 0;
        for(int right=0;right < n;right++)
        {
            m[arr[right]]++;
            while(left <= right && m.size() == s.size())
            {
                ans += (n - right);
                if(m[arr[left]] == 1)
                    m.erase(arr[left]);
                else m[arr[left]]--;    
                left++;
            }
        }
        return ans;
    }
};


// { Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int a[n];
		for(int i=0;i<n;++i)
			cin>>a[i];
		Solution ob;	
		cout<<ob.countDistinctSubarray(a,n)<<endl;
	}
	return 0;
}  // } Driver Code Ends