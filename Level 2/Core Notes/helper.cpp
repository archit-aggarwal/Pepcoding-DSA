#define setbits(x)      __builtin_popcountll(x)
#define zerobits(x)     __builtin_ctzll(x)
#define ps(x,y)         fixed << setprecision(y) << x
#define rep(i,a,b)      for(long long i=a;i<b;i++)
#define mem1(a)         memset(a,-1,sizeof(a))
#define mem0(a)         memset(a,0,sizeof(a))
#define Ceil(a , b) 	(((a) / b) + ((a)%b && 1))

#define pii             pair<long long,long long>
#define ppi           pair<long long, pair<long long, long long>>
#define pb					push_back
#define mp  				make_pair
#define setbits(x)      __builtin_popcountll(x)
#define zerobits(x)     __builtin_ctzll(x)
#define ps(x,y)         fixed << setprecision(y) << x
#define rep(i,a,b)      for(long long i=a;i<b;i++)
#define Ceil(a , b) 		(((a) / b) + ((a)%b && 1))
#define mod             1000000007
#define inf             1e18
#define ll 				unsigned long long

// Fast Input Output
void file_input_output()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
}

ll gcd(ll a, ll b)
{
	if (a == 0) return b;
	return gcd(b % a, a);
}

ll lcm(ll a, ll b)
{return a * (b / gcd(a, b));}

// Modular Exponentiation
ll power(ll n, ll p, ll m = mod)
{
	ll res = 1ll;
	n %= m;
	while (p)
	{
		if (p & 1ll) res = (res * n) % m;
		p = p >> 1ll;
		n = (n * n) % m;
	}
	return res % m;
}

// 8 Directions Neighbour
const int x8[8] = {1, 0, -1, 0, 1, 1, -1, -1};
const int y8[8] = {0, 1, 0, -1, -1, 1, -1, 1};

// 4 Directions Neighbour
const int x4[4] = {1, -1, 0, 0};
const int y4[4] = {0, 0, -1, 1};

// (a * b) % m
inline ll Mul(ll a, ll b, ll m = mod)
{return ((a % m) * (b % m)) % m;}

// (a + b) % m
inline ll Add(ll a, ll b, ll m = mod)
{return ((a % m) + (b % m)) % m;}

// (a - b) % m
inline ll Sub(ll a, ll b, ll m = mod)
{return ((a % m) - (b % m) + m) % m;}

// (a / b) % m {m must be prime}
inline ll Div(ll a, ll b, ll m = mod)
{return ((a % m) * power(b , m - 2ll, m)) % m; }

// Check Palindrome from i to j
bool isPalindrome(string s, ll i, ll j)
{
	while (i < j)
	{
		if (s[i] != s[j])
			return false;
		i++; j--;
	}
	return true;
}

// Comparator
class Comp {
public:
	bool operator()(ppi &a, ppi&b) {
		return a.first > b.first;
	}
};

// Check Prime
bool isPrime(ll n) {
	if (n <= 3) return true;
	for (ll i = 2ll; i * i <= n; i++)
		if (n % i == 0)return 0;
	return 1;
}

// Prime Seive
bitset<1000005> b;
vector<ll> prime;
void primeseive()
{
	b.set();
	b[0] = b[1] = 0;
	for (ll i = 2; i < 1000005; i++)
	{
		if (b[i])
		{
			prime.push_back(i);
			for (ll j = i * i; j < 1000005; j += i)
				b[j] = 0;
		}
	}
}

// Prime Factorization
vector<ll> factorization(ll n)
{
	vector<pair<ll, ll>> factors;
	for (ll i = 0; prime[i]*prime[i] <= n ; i++)
	{
		int count = 0;
		while (n % prime[i] == 0)
		{
			n = n / prime[i];
			count++;
		}
		if (count)
			factors.push_back(make_pair(prime[i], count));
	}
	if (n != 1)
		factors.push_back(make_pair(n, 1));
	return factors;
}

// Extended GCD
ll gcdExtended(ll a, ll b, ll* x, ll* y)
{
	if (a == 0)
	{
		*x = 0, *y = 1;
		return b;
	}
	ll x1, y1;
	ll gcd = gcdExtended(b % a, a, &x1, &y1);
	*x = y1 - (b / a) * x1;
	*y = x1;
	return gcd;
}

// MMI (Modulo Multiplicative Inverse)
ll modInverse(ll a, ll m)
{
	ll x, y;
	ll gcd = gcdExtended(a, m, &x, &y);
	if (gcd != 1)
		return 0; // MMI Doesnot Exist
	ll res = (x % m + m) % m; // Make Positive
	return res;
}

// Totient Function
// => Count Nos Coprime with N in [1, N]
// i.e. GCD of both numbers is 1.
ll totient(int n)
{
	ll result = n;
	for (int i = 2; i * i <= n; i++)
	{
		if (n % i == 0)
		{
			while (n % i == 0)
				n /= i;
			result -= result / i;
		}
	}
	if (n > 1)  result -= result / n;
	return result;
}

// Chinese Remainder Theorem
// Find Minimum X such that
// X mod num[i] = rem[i]
ll chinese(vector<ll> &num, vector<ll> &rem, ll n)
{
	ll prod = 1ll;
	for (ll i = 0; i < n; i++)
		prod *= num[i];

	ll result = 0;
	for (ll i = 0; i < n; i++)
	{
		ll pp = prod / num[i];
		result += rem[i] * modInverse(pp, num[i]) * pp;
	}

	return result % prod;
}

// Segment Tree with Point Update
ll* tree;
void build(vector<ll> &arr, ll i, ll l, ll r)
{
	if (l == r)
	{ tree[i] = arr[l]; return; }
	if (l > r) return;
	ll mid = l + (r - l) / 2;
	build(arr, 2 * i + 1, l, mid);
	build(arr, 2 * i + 2, mid + 1, r);
	tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
}
// Build Call
// tree = new int[4 * n + 1];
// build(nums, 0, 0, n - 1);

ll query(ll i, ll s, ll e, ll qs, ll qe)
{
	if (qs > e || qe < s) return 0;
	if (s >= qs && e <= qe) return tree[i];
	ll mid = s + (e - s) / 2;
	ll left = query(2 * i + 1, s, mid, qs, qe);
	ll right = query(2 * i + 2, mid + 1, e, qs, qe);
	return left + right;
}
// Query Call
// return query(0,0,n-1,i,j);

void update(ll idx, ll s, ll e, ll i, ll val)
{
	if (i < s || i > e) return;
	if (s == e)
	{
		tree[idx] = val;
		return;
	}
	ll mid = s + (e - s) / 2;
	update(2 * idx + 1, s, mid, i, val);
	update(2 * idx + 2, mid + 1, e, i, val);
	tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
}
// Update Call
// return update(0, 0, n-1, i, val);


// Segment Tree (Range Update -> Lazy Propogation)
int tree[10005] = {0};
int lazy[10005] = {0};

void update(int si, int ss, int se, int us,
            int ue, int diff)
{
	if (lazy[si] != 0)
	{
		tree[si] += (se - ss + 1) * lazy[si];
		if (ss != se)
		{
			lazy[si * 2 + 1] += lazy[si];
			lazy[si * 2 + 2] += lazy[si];
		}
		lazy[si] = 0;
	}

	if (ss > se || ss > ue || se < us)
		return ;

	if (ss >= us && se <= ue)
	{
		tree[si] += (se - ss + 1) * diff;
		if (ss != se)
		{
			lazy[si * 2 + 1] += diff;
			lazy[si * 2 + 2] += diff;
		}
		return;
	}

	int mid = (ss + se) / 2;
	update(si * 2 + 1, ss, mid, us, ue, diff);
	update(si * 2 + 2, mid + 1, se, us, ue, diff);

	tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
}

// Range Update Call -> [us, ue] Both Included
// update(0, 0, n-1, us, ue, diff);

int query(int ss, int se, int qs, int qe, int si)
{
	if (lazy[si] != 0)
	{
		tree[si] += (se - ss + 1) * lazy[si];
		if (ss != se)
		{
			lazy[si * 2 + 1] += lazy[si];
			lazy[si * 2 + 2] += lazy[si];
		}
		lazy[si] = 0;
	}

	if (ss > se || ss > qe || se < qs)
		return 0;

	if (ss >= qs && se <= qe)
		return tree[si];

	int mid = (ss + se) / 2;
	return query(ss, mid, qs, qe, 2 * si + 1)
	       + query(mid + 1, se, qs, qe, 2 * si + 2);
}

// Query Call -> [qs, qe] Both Included
// query(0, n-1, qs, qe, 0);

void build(int arr[], int ss, int se, int si)
{
	if (ss > se) return;

	if (ss == se)
	{
		tree[si] = arr[ss];
		return;
	}

	int mid = (ss + se) / 2;
	build(arr, ss, mid, si * 2 + 1);
	build(arr, mid + 1, se, si * 2 + 2);
	tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
}

// Build Call
// build(arr, 0, n-1, 0);

// Disjoint Set Union (DSU)
vector<ll> dsu(n, -1);
// DSU Node => -k => Leader of Component of Size k
// +k => Child with Parent k

// Find (With Path Compression)
ll Find(ll v)
{
	if (dsu[v] < 0) return v;
	dsu[v] = Find(dsu[v]);
	return dsu[v];
}

// Union By Size
void Union(ll x, ll y)
{
	ll a = Find(x), b = Find(y);
	if (a == b)
		return; // Same Component OR Same Cycle

	// Larger Size => More Negative Number
	if (dsu[a] <= dsu[b])
	{
		dsu[a] += dsu[b];
		dsu[b] = a;
	}
	else
	{
		dsu[b] += dsu[a];
		dsu[a] = b;
	}
}