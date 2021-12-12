#include<bits/stdc++.h>
using namespace std;
#define pi              pair<long long,long long>
#define pqmax           priority_queue<long long>
#define pqmin           priority_queue<long long,vector<long long>,greater<long long>>
#define setbits(x)      __builtin_popcountll(x)
#define zerobits(x)     __builtin_ctzll(x)
#define ps(x,y)         fixed << setprecision(y) << x
#define rep(i,n)		for(int i=1;i<=n;i++)
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

bool calc_wood(vector<ll> &arr, ll cut, ll req)
{
	ll ans = 0;
	for (auto i : arr)
	{
		ans += max(i - cut, 0ll);
		if (ans >= req) return true;
	}
	return false;
}

int main()
{
	file_input_output();
	long long int n, m; cin >> n >> m;
	long long int start = 0ll, end = 0ll;
	vector<long long int> arr;
	for (int i = 0; i < n; i++)
	{
		long long int x;
		cin >> x;
		end = max(end, x);
		arr.push_back(x);
	}
	sort(arr.begin(), arr.end());
	ll ans = 0;
	while (start <= end)
	{
		ll middle = start + (end - start) / 2;
		if (calc_wood(arr, middle, m))
		{
			start = middle + 1;
			ans = middle;
		}
		else end = middle - 1;
	}
	cout << ans;
}