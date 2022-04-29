// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    void segregate0and1(int arr[], int n) {
        int countOf0s = 0;
        
        // Counting 0s and 1s
        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                countOf0s++;
            }
        }
        
        // Store the left elements as 0 and right elements as 1
        for(int i=0; i<n; i++){
            if(i < countOf0s)
                arr[i] = 0;
            else arr[i] = 1;
        }
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        ob.segregate0and1(arr, n);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}  // } Driver Code Ends