#include <bits/stdc++.h>
using namespace std;

bool isPossible(int d, vector<int> &stalls, int c, int n){
	int placed = 1, placedAt = stalls[0];
	for(int i=1; i<n; i++){
		if(placedAt+d <= stalls[i]){
			placed++;
			placedAt = stalls[i];
		}
	}
	if(placed >= c)
		return true;
	return false;
}

int main() {
	// your code goes here
	int t; cin>>t;
	while(t--){
		int n, c; cin>>n>>c;
		vector<int> stalls(n);
		for(int &stall:stalls)	cin>>stall;
		
		sort(stalls.begin(), stalls.end());
		int low = 1, high = stalls[n-1] - stalls[0];
		int ans = 1;
		while(low<=high){
			int mid = low + (high - low)/2;
			if(isPossible(mid, stalls, c, n)){
				ans = mid;
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		cout<<ans<<endl;
	}
	return 0;
}
