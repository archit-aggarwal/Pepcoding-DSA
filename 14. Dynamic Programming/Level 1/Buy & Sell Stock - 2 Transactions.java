import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] cost = new int[n];
        for(int i=0; i<n; i++)
            cost[i] = scn.nextInt();
            
        int[] left = new int[n];
        int[] right = new int[n];
        
        int buyingDay = cost[0];
        // Aaj ya aj se pehle becha ho
        for(int i=1; i<n; i++)
        {
            int currProfit = cost[i] - buyingDay;
            
            if(left[i - 1] > currProfit)
                currProfit = left[i - 1];
                
            left[i] = currProfit;
            
            buyingDay = Math.min(cost[i], buyingDay);
        }
        
        
        int sellingDay = cost[n - 1];
        // Aj ya aj ke bad khareedna ho
        for(int i=n-2; i>=0; i--)
        {
            int currProfit = sellingDay - cost[i];
            
            if(right[i + 1] > currProfit)
                currProfit = right[i + 1];
            
            right[i] = currProfit;
            
            sellingDay = Math.max(cost[i], sellingDay);
        }
        
        
        // Maximum of left[i] + right[i] for each day
        int maxProfit = 0;
        for(int i=0; i<n; i++)
        {
            int currProfit = left[i] + right[i];
            if(currProfit > maxProfit)
                maxProfit = currProfit;
        }
        
        System.out.println(maxProfit);
        
    }


}
