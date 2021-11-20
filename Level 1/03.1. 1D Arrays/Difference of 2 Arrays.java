import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++)
        arr1[i] = scn.nextInt();
    
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++)
        arr2[i] = scn.nextInt();
    
    int n3 = n2;
    int[] arr3 = new int[n3];
    
    int i1 = n1 - 1, i2 = n2 - 1, i3 = n3 - 1;
    int borrow = 0;
    while(i3 >= 0)
    {
        int dig1 = (i1 >= 0) ? arr1[i1] : 0;
        int dig2 = (i2 >= 0) ? arr2[i2] : 0;
        int diff = (dig2 - borrow) - dig1;
        if(diff < 0)
        {
            diff = diff + 10;
            borrow = 1;
        }
        else borrow = 0;
        
        arr3[i3] = diff;
        i1--; i2--; i3--;
    }
    
    int i = 0;
    while(arr3[i] == 0) // leading 0s
    {
        i++;
    }
    
    for(; i < n3; i++)
        System.out.println(arr3[i]);
 }

}