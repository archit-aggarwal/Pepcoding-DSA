// Leetcode 399 : https://leetcode.com/problems/evaluate-division/
#include <bits/stdc++.h>
using namespace std;

struct node
{
    int parent = -1;
    double val = 1.0;
};

vector<node> dsu;

int Find(int x)
{
    if (dsu[x].parent == -1)
        return x;
    int root = Find(dsu[x].parent);
    dsu[x].val *= dsu[dsu[x].parent].val;
    dsu[x].parent = root;
    return root;
}
void Union(int x, int y, double v)
{
    int a = Find(x), b = Find(y);
    if (a == b)
        return;
    dsu[a].parent = b;
    dsu[a].val = (v * dsu[y].val) / dsu[x].val;
}

class Solution
{
public:
    vector<double> calcEquation(vector<vector<string>> &equations, vector<double> &values, vector<vector<string>> &queries)
    {
        unordered_map<string, int> idx;
        int ptr = 0;
        for (int i = 0; i < equations.size(); i++)
        {
            if (idx.find(equations[i][0]) == idx.end())
                idx[equations[i][0]] = ptr++;
            if (idx.find(equations[i][1]) == idx.end())
                idx[equations[i][1]] = ptr++;
        }

        dsu.clear();
        dsu.resize(idx.size());
        for (int i = 0; i < equations.size(); i++)
            Union(idx[equations[i][0]], idx[equations[i][1]], values[i]);

        vector<double> res;
        for (int i = 0; i < queries.size(); i++)
        {
            string x = queries[i][0], y = queries[i][1];
            if (idx.find(x) == idx.end() || idx.find(y) == idx.end())
                res.push_back(-1.0);
            else if (Find(idx[x]) != Find(idx[y]))
                res.push_back(-1.0);
            else
                res.push_back(dsu[idx[x]].val / dsu[idx[y]].val);
        }
        return res;
    }
};