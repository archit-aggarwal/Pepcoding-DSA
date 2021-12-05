#include<bits/stdc++.h>
using namespace std;
#define pi              pair<int,int>
#define s(type)         set<type>
#define m(type)         map<type,int>
#define hashmap(type)   unordered_map<type,int>
#define hashset(type)   unordered_set<type>
#define t(x)            int x; cin>>x; while(x--)
#define minheap(type)   priority_queue<type,vector<type>,greater<type>>
#define maxheap(type)   priority_queue<type,vector<type>,less<type>>
#define mod             1000000007
#define ll              long long int

void file_input_output()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
}
int floor_sqroot(int n)
{
	int l = 1, r = n / 2 + 1;
	int mid;
	while (l <= r)
	{
		mid = (l + r) / 2;;
		if (mid * mid == n) return mid;
		if (mid * mid > n) r = mid - 1;
		else l = mid + 1;
	}
	return r; // for floor value
}
int ceil_sqroot(int n)
{
	int l = 1, r = n / 2 + 1;
	int mid;
	while (l <= r)
	{
		mid = (l + r) / 2;;
		if (mid * mid == n) return mid;
		if (mid * mid > n) r = mid - 1;
		else l = mid + 1;
	}
	return l; // for ceil value
}
double sqroot(int n, int precision)
{
	double ans = floor_sqroot(n);
	int i = 0; double j = 0.1;
	while (precision--)
	{
		while (ans * ans <= n)  ans += j;
		ans = ans - j;
		j = j / 10;
	}
	return ans;
}
int main()
{
	file_input_output();
	cout << floor_sqroot(64) << " " << ceil_sqroot(64) << " ";
	cout << sqroot(64, 3) << endl;
	cout << floor_sqroot(65) << " " << ceil_sqroot(65) << " ";
	cout << sqroot(65, 3) << endl;
	cout << floor_sqroot(63) << " " << ceil_sqroot(63) << " ";
	cout << sqroot(63, 3) << endl;
	cout << floor_sqroot(16) << " " << ceil_sqroot(16) << " ";
	cout << sqroot(16, 3) << endl;
	cout << floor_sqroot(17) << " " << ceil_sqroot(17) << " ";
	cout << sqroot(17, 3) << endl;
	cout << floor_sqroot(15) << " " << ceil_sqroot(15) << " ";
	cout << sqroot(15, 3) << endl;
	// Time Complexity Analysis
	// Ceil & Floor - O(log n)
	// square root upto given precision p - O(log n + p)
	return 0;
}
