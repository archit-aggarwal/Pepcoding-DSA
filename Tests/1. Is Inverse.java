import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for(int i=0; i<n; i++)
            a[i] = scn.nextInt();
        
        for(int i=0; i<n; i++)
            b[i] = scn.nextInt();
        
        int[] inv = new int[n];
        for(int i=0; i<n; i++){
            inv[a[i]] = i;
        }
        
        boolean temp = true;
        for(int i=0; i<n; i++){
            if(inv[i] != b[i]){
                temp = false;
                break;
            }
        }
        System.out.println(temp);
    }
}
