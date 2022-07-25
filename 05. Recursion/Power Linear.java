import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        int xpn = power(x, n);
        System.out.println(xpn);
    }

    public static int power(int x, int n){
        // Base Case: x^0 = 1
        if(n == 0) return 1;
        
        // 1. Calculate x ^ n-1 using Faith
        int xpn1 = power(x, n-1);
        
        // 2. Calculate x ^ n using x ^ n-1
        int xpn = xpn1 * x;
        
        // 3. Calculate x ^ n
        return xpn;
    }

}
