class Solution 
{
    
    public static boolean isPossible(int[] pages, int books, int maxLoad, int totalStud){
        int currStud = 1, currPages = 0;
        
        for(int i=0; currStud <= totalStud && i<books; i++){
            
            if(currPages + pages[i] <= maxLoad){
                currPages += pages[i];
            } else {
                currStud++;
                currPages = pages[i];
            }
            
        }
        
        if(currStud > totalStud) return false;
        return true;
    }
    
    public static int maxOfArray(int[] pages, int books){
        int max = 0;
        for(int i=0; i<books; i++){
            max = Math.max(max, pages[i]);
        }
        return max;
    }
    
    public static int sumOfArray(int[] pages, int books){
        int sum = 0;
        for(int i=0; i<books; i++){
            sum += pages[i];
        }
        return sum;
    }
    
    public static int findPages(int[] pages,int books,int students)
    {
        int low = maxOfArray(pages, books);
        int high = sumOfArray(pages, books);
        int ans = high;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isPossible(pages, books, mid, students) == true){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
};
