#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    double minmaxGasDist(vector<int> &stations, int K) 
    {
        double low = 0, high = 1e8;
        while (high - low > 1e-6) 
        {
            double mid = (low + high) / 2.0;
            if (possible(mid, stations, K)) high = mid;
            else low = mid;
        }
        return low;
    }

    bool possible(double x, vector<int> &stations, int K) 
    {
        int count = 0;
        for (int i = 1; i < stations.size(); i++) 
            count += (int) ((stations[i] - stations[i - 1]) / x);
        return count <= K;
    }
};