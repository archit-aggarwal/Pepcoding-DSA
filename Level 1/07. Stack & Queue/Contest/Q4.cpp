// Video Solution - https://www.youtube.com/watch?v=k-cdbNQcC7E&ab_channel=HackersRealm

#include <vector>
#include <list>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <limits>
#include <tuple>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <cassert>

using namespace std;

typedef struct query
{
    int type, remove;
    string add;
}query;

char stak[1000003];

int topp = 0;

void push(string s)
{
    for(int i = 0 ; i < s.length(); i++)
    {
        stak[++topp] = s[i];
    }
    assert(topp <= 1000000);
}

string pop(int remove)
{
    assert(remove >= 0 && remove <= topp);
    string popped = "";
    int del = remove;
    for (int  i = topp; del > 0; i--, del--) {
        popped = stak[i] + popped;
    }
    topp -= remove;
    return popped;
}

int main()
{
    int t, type, remove, k;
    stack<query> q_stack;
    cin>>t;
    while(t--)
    {
        cin>>type;
        if(type == 1)
        {
            string add;
            cin>>add;
            push(add);
            query last;
            last.type = type;
            last.add = add;
            q_stack.push(last);
        }
        else if(type == 2)
        {
            cin>>remove;
            string popped = pop(remove);
            query last;
            last.type = type;
            last.remove = remove;
            last.add = popped;
            q_stack.push(last);
        }
        else if(type == 3)
        {
            cin>>k;
            assert(k >= 1 && k <= topp);
            cout<<stak[k]<<endl;
        }
        else
        {
            query last = q_stack.top();
            q_stack.pop();
            if(last.type == 1)
            {
                int remove = (last.add).length();
                string popped = pop(remove);
            }
            else
            {
                push(last.add);
                assert(topp >= 1 && topp <= 1000000);
            }
        }
    }
    return 0;
}
