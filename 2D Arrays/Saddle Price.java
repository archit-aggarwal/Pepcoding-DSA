import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }
        
        boolean isSaddlePtAchieved = false;
        for(int i=0; i<n; i++)
        {
            // Minimum of row i
            int Min = Integer.MAX_VALUE, col = 0;
            for(int j=0; j<n; j++)
            {
                if(arr[i][j] < MIn)
                {
                    Min = arr[i][j];
                    col = j;
                }
            }
            
            // Maximum of col j
            int Max = Integer.MIN_VALUE;
            for(int k=0; k<n; k++)
            {
                if(arr[k][col] > Max)
                    Max = arr[k][col];
            }
            
            // Maximum Element == Minimum Element;
            if(Min == Max)
            {
                System.out.println(Min);
                isSaddlePtAchieved = true;
                break;
            }
        }
        
        if(isSaddlePtAchieved == false)
            System.out.println("Invalid input");
    }

}
