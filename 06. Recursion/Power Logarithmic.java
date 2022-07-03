import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xpn = power(x, n);
        System.out.println(xpn);
    }
    
    // Number of calls in power2 : HomeWork
//     public static int power2(int x, int n)
//     {
//         if(n == 0) return 1;
        
//         int xpn = power2(x, n/2) * power2(x, n/2);
//         if(n % 2 == 1) xpn = xpn * 2;
//         return xpn;
//     }
    
    public static int power(int x, int n){
        // Base Case x^0 = 1
        if(n == 0) return 1;
        
        // 1. Faith : x ^ n/2
        int xpnb2 = power(x, n/2);
        
        // 2. x^n = x^n/2 * x^n/2
        int xpn = xpnb2 * xpnb2;
        
        // 3. If n is odd
        if(n % 2 == 1) xpn = xpn * x;
        
        // 4. Return
        return xpn;
    }

}
