import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = scn.nextInt();
        }
        
        
        int buyingDayCost = cost[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++)
        {
            int currProfit = cost[i] - buyingDayCost;
            
            if(currProfit > maxProfit)
                maxProfit = currProfit;
            
            if(cost[i] < buyingDayCost)
                buyingDayCost = cost[i];
        }
        
        System.out.println(maxProfit);
    }

}
