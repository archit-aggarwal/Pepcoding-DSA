#include<bits/stdc++.h>
using namespace std;
#define MAX 1000

vector<vector<int>> uniqueRow(int M[MAX][MAX],int row,int col);

int main()
{
    int T;
    cin>>T;
    while(T--)
    {
    	int n,m;
    	cin>>n>>m;
    	int a[MAX][MAX];
    	for(int i=0;i<n;i++)
    	for(int j=0;j<m;j++)
    	cin>>a[i][j];
    	vector<vector<int>> vec = uniqueRow(a,n,m);
    	for(int i = 0;i<vec.size();i++){
    	    for(int x : vec[i]){
    	        cout<<x<<" ";
    	    }
    	    cout<<"$";
    	}
    	cout<<endl;
    }
}
// } Driver Code Ends

struct trie
{
    trie *left = nullptr;
    trie *right = nullptr;
};

void insert(trie *root , int x[], int n)
{
    for(int i=0;i<n;i++)
    {
        if(x[i] == 1)
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
    }
}

bool search(trie *root, int x[], int n)
{
    for(int i=0;i<n;i++)
    {
        if(x[i] == 1)
        {
            if(!root->right) return false;
            root = root->right;
        }
        else
        {
            if(!root->left) return false;
            root = root->left;
        }
    }
    return true;
}

/*You are required to complete this function*/
vector<vector<int>> uniqueRow(int M[MAX][MAX],int row,int col)
{   
    trie *root = new trie;
    for(int i=0;i<row;i++)
    {
        if(search(root, M[i], col) == false)
        {   
            insert(root, M[i], col);
            for(int j=0;j<col;j++)
                cout<<M[i][j]<<" ";
            cout<<"$";
        }
    }
}