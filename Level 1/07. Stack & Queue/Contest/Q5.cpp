// Video Solution - https://www.youtube.com/watch?v=te84mUjitYA&ab_channel=HackersRealm

#include<bits/stdc++.h>
using namespace std;

const int N = 1300;
const int M = 110000;
int ans[M], stk[M], tmpstk[M], primes[N];
int atop, top, ttop, num;

void primeFun(){
    num = 0;
    for(int i=2; i<M && num < 1200; i++){
        bool isPrime = true;
        for(int j=2; j * j <= i; j++){
            if(i%j == 0)    isPrime = false;
        }
        if(isPrime) primes[num++] = i;
    }
}

int main(){
    int n, q;
    cin >> n >> q;
    primeFun();
    atop = top = 0;
    for(int i=0; i<n; i++)  cin>>stk[top++];
    
    for(int i=0; i<q; i++){
        ttop = 0;
        while(top){
            int v = stk[--top];
            if(v % primes[i] == 0)  ans[atop++] = v;
            else                    tmpstk[ttop++] = v;
        }
        while(atop) cout<<ans[--atop]<<endl;
        
        for(int j=0; j<ttop; j++)   stk[j] = tmpstk[j];
        top = ttop;
        
        if(!top)    break;
    }
    while(top){
        cout<<stk[--top]<<endl;
    }
    return 0;
}
