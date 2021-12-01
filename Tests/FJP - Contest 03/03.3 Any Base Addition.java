import java.io.*;
import java.util.*;

public class Solution {
    public static int anyBasetoDecimal(int n, int b){
        int res = 0;
        int multiplier = 1;
        
        while(n > 0){
            int divisor = n / 10;
            int remainder = n % 10;
            
            n = divisor;
            res = res + remainder * multiplier;
            multiplier *= b;
        }
        
        return res;
    }
    
    public static int decimalToAnyBase(int n, int b){
       int res = 0;
       int multiplier = 1;
       
       while(n > 0){
           int divisor = n / b;
           int remainder = n % b;
           
           n = divisor;
           res = res + remainder * multiplier;
           multiplier *= 10;
       }
       
       return res;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int b1 = scn.nextInt();
        int n2 = scn.nextInt();
        int b2 = scn.nextInt();
        int db = scn.nextInt(); 
        
        int n1db = anyBasetoDecimal(n1, b1);
        int n2db = anyBasetoDecimal(n2, b2);
        int ans = decimalToAnyBase(n1db + n2db, db);
        System.out.println(ans);
    }
}