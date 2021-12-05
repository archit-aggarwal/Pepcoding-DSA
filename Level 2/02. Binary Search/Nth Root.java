public int NthRoot(int n, int m)
{
    int low = 1, high = m;

    while(low <= high){
        int mid = (low + high)/2;
        int mul = (int)Math.pow(mid,n);
        if(mul == m) return mid;
        else if(mul > m) high = mid - 1;
        else low = mid + 1;

    }
    return -1;
}
