// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    void segregate0and1(int arr[], int n) {
        int start = 0, end = n - 1;
        while(start < end){
            
            // Skip All the 0s in left
            while(start < end && arr[start] == 0)
                start++;
                
            // Skip All the 1s in right
            while(start < end && arr[end] == 1)
                end--;
                
            if(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; end--;
            }
            
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