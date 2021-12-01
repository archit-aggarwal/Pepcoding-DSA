import java.io.*;
import java.util.*;

public class Solution {
    public static int anyBasetoDecimal(String str, int b){
        int res = 0;
        int multiplier = 1;
        
        for(int i=str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                res = res + multiplier * (ch - 'a' + 10);    
            } else {
                res = res + multiplier * (ch - '0');
            }
            
            multiplier *= b;
        }
        
        return res;
    }
    
    public static StringBuilder decimalToAnyBase(int n, int b){
       StringBuilder res = new StringBuilder("");
       
       while(n > 0)
       {
           int divisor = n / b;
           int remainder = n % b;
           
           if(remainder < 10){
               res.append(remainder);
           } else {
               res.append((char)(remainder - 10 + 'a'));
           }
           
           n = divisor;
       }
       
       return res.reverse();
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int srcBase = scn.nextInt();
        int destBase = scn.nextInt();
        
        int dec = anyBasetoDecimal(str, srcBase);
        StringBuilder res = decimalToAnyBase(dec, destBase);
        System.out.println(res);
    }
}