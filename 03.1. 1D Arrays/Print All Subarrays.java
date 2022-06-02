import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    
    for(int stpt = 0; stpt < n; stpt++)
    {
        for(int enpt = stpt; enpt < n; enpt++)
        {
            // Starting Pt, Ending Pt
            for(int i=stpt; i<=enpt; i++) // Print Subarray
                System.out.print(a[i] + "	");
            System.out.println();
        }
    }
 }

}