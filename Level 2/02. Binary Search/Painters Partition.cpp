#define m 10000003
bool check(vector<int> &pages,int books,int stud,long long int mid)
{
    int stud_num = 1;
    long long int sum = 0;
    for(int i=0;i<books;i++)
    {
         if(sum + pages[i] <= mid)
          sum += pages[i];
         else
          {   
              stud_num++;
              sum = pages[i];
              if(stud_num > stud)
               return false;
          }  
    }
    return true;
}
int Solution::paint(int stud, int B, vector<int> &pages) {
    int books = pages.size();
    long long int end = 0;
    long long int start = 0;
    for(int i=0;i<books;i++)
    { 
        end = (end + pages[i])%m;
        start = (max((int)start,pages[i]))%m;
    }
    
    if(stud == books) return (B*start)%m;
    if(stud == 1) return (B*end)%m;
     
     long long int ans,mid;
     while(start <= end)
     {
         mid = (start+end)/2;
         if(check(pages,books,stud,mid))
          { end = mid-1;
           ans = mid; }
          else start = mid+1;
     }
     return (B*ans)%m;
}
