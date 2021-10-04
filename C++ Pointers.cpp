#include<bits/stdc++.h>
using namespace std;


int main(){
    
    // Pointer Basics
    int ans = 5;
    cout << ans << " " << &ans << endl;
    
    int* ptr = &ans;
    cout << ptr << "   " << &ptr << "   " << *ptr << endl;
    
    // Pointer Types
    int i = 5;
    int* ip = &i;
    cout << i << " " << &i << " " << ip << " " << *ip << endl;
    
    i = 10;
    cout << i << " " << &i << " " << ip << " " << *ip << endl;

    *ip = 15;
    cout << i << " " << &i << " " << ip << " " << *ip << endl;
    
    int i2 = 30;
    ip = &i2;
    cout << i2 << " " << &i2 << " " << ip << " " << *ip << endl;
    
    *ip = 50;
    cout << i2 << " " << &i2 << " " << ip << " " << *ip << endl;
    
    double d = 50.0;
    double* dp = &d;
    cout << d << " " << &d << " " << dp << " " << *dp << endl;
    
    bool b = true;
    bool* bp = &b;
    cout << b << " " << &b << " " << bp << " " << *bp << endl;
    
    cout << sizeof(i) << " " << sizeof(d) << " " << sizeof(b) << endl;
    cout << sizeof(ip) << " " << sizeof(dp) << " " << sizeof(bp) << endl;
    
    // Pointer Arithmetic
    int arr[] = {5, 10, 15, 20, 25, 30};
    
    int* ptr = &(arr[0]);
    cout << ptr << " " << *ptr << endl;
    
    ptr = ptr + 1;
    cout << ptr << " " << *ptr << endl;
    
    ptr = ptr + 1;
    cout << ptr << " " << *ptr << endl;
    
    ptr = ptr - 1;
    cout << ptr << " " << *ptr << endl;
    
    double arr[] = {5, 10, 15, 20, 25, 30};
    
    double* ptr = &(arr[0]);
    cout << ptr << " " << *ptr << endl;
    
    ptr = ptr + 1;
    cout << ptr << " " << *ptr << endl;
    
    ptr = ptr + 1;
    cout << ptr << " " << *ptr << endl;
    
    ptr = ptr - 1;
    cout << ptr << " " << *ptr << endl;
    
    double* ptr1 = &(arr[3]);
    double* ptr2 = &(arr[3]);
    
    int dist = (ptr2 - ptr1);
    cout << dist << endl;
    
    // double* ptr1 + ptr2 -> invalid
    // double* ptr3 = ptr1 * ptr2; -> invalid
    // double* ptr1 / ptr2; -> invalid
    
    // Pointer Comparison
    if(ptr1 < ptr2){
        cout << "ptr1 is pointing to smaller index";
    } else if(ptr2 < ptr1) {
        cout << "ptr2 is pointing to smaller index";
    } else {
        cout << "pointing to same location";
    }
    
    // Pointer to Pointer
    int ans = 5;
    int* ptr = &ans;
    int** ptop = &ptr;
    
    cout << ans << " " << *ptr << " " << **ptop << endl;
    cout << &ans << " " << ptr << " " << *ptop << endl;
    
    **ptop = 10;
    cout << ans << endl;
    
    int*** ptoptop = &ptop;
    ***ptoptop = 15;
    cout << ans << endl;
    
    return 0;
}
