#include<bits/stdc++.h>
using namespace std;
#define pi              pair<long long,long long>
#define pqmax           priority_queue<long long>
#define pqmin           priority_queue<long long,vector<long long>,greater<long long>>
#define setbits(x)      __builtin_popcountll(x)
#define zerobits(x)     __builtin_ctzll(x)
#define ps(x,y)         fixed << setprecision(y) << x
#define rep(i,n)		    for(int i=1;i<=n;i++)
#define ll              long long int
#define mod             1000000007
#define inf             1e18

void file_input_output()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
// #ifndef ONLINE_JUDGE
// 	freopen("input.txt", "r", stdin);
// 	freopen("output.txt", "w", stdout);
// #endif
}

bool calc_prata(vector<ll> &arr, ll time, ll pratas)
{
	ll total = 0;
	for (int i = 0; i < arr.size(); i++)
	{
		ll curr_cook = 0;
		if (time >= arr[i])
			curr_cook = (-1 + sqrt(1.0 + (8.0 * time) / arr[i])) / 2;
		total += max(curr_cook, 0ll);
		if (total >= pratas)
			return true;
	}
	return false;
}
int main()
{
	file_input_output();
	long long int t; cin >> t;
	while (t--)
	{
		ll x; cin >> x;
		int n; cin >> n;
		vector<ll> arr(n);
		for (ll i = 0; i < n; i++)
			cin >> arr[i];
		sort(arr.begin(), arr.end());
		ll start = 0, end = ((x * (x + 1)) * arr[n - 1]) / 2;
		ll res = end;
		while (start <= end)
		{
			ll middle = start + (end - start) / 2;
			if (calc_prata(arr, middle, x))
			{
				res = middle;
				end = middle - 1 ;
			}
			else start = middle + 1;
		}
		cout << res << endl;
	}
}