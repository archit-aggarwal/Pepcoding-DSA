import java.io.*;
import java.util.*;

public class Main{

public static int decimalToBinary(int dec)
{
    int bin = 0, power = 1;
    while(dec > 0)
    {
        int dig = dec % 2;
        dec = dec / 2;
        bin = bin + dig * power;
        power = power * 10;
    }
    return bin;
}

public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    
    int totalSubsets = (int)Math.pow(2, n);
    for(int dec=0; dec<totalSubsets; dec++)
    {
        int binaryNo = decimalToBinary(dec);
        
        // System.out.println(binaryNo);
        // Subset
        int div = (int)Math.pow(10, n-1);
        for(int i=0; i<n; i++)
        {
            int quot = binaryNo / div;
            if(quot % 10 == 0)
                System.out.print("-	");
            else System.out.print(a[i] + "	");
            div = div / 10;
        }
        System.out.println();
    }
 }

}