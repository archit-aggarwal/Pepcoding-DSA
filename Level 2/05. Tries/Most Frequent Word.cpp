
#include <bits/stdc++.h>
using namespace std;

string mostFrequentWord(string arr[], int n);

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        string arr[n];
        for (int i = 0; i < n; i++) cin >> arr[i];

        cout << mostFrequentWord(arr, n) << endl;
    }
    return 0;
}
// } Driver Code Ends


// User function template for C++

// arr : given array of string
// n : number of string in the array
// return the expected answer

pair<string, int> res;
class Node
{
    public:
    char data;
    unordered_map<char,Node*> children;
    int terminal;
    Node(char data)
    {
        this->data = data;
        terminal = 0;
    }
};
void insert(Node* root, string s)
{
    Node* temp = root;
    for(int i=0;s[i]!='\0';i++)
    {
        if(temp->children.find(s[i]) != temp->children.end())
            temp = temp->children[s[i]];
        else 
        {
            Node* newNode = new Node(s[i]);
            temp->children[s[i]] = newNode;
            temp = newNode;
        }
    }
    temp->terminal++;
    if(temp->terminal > res.second)
        res = make_pair(s, temp->terminal);
}
string mostFrequentWord(string arr[], int n) {
    Node* root = new Node('\0');
    res = make_pair("", 0);
    for(int i=n-1;i>=0;i--) insert(root, arr[i]);
    return res.first;
}