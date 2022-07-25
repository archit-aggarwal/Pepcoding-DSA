import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int t3 = scn.nextInt();
        
        toh(n, t1, t2, t3);
    }

    public static void toh(int n, int t1, int t2, int t3){
        if(n == 0) return;
        
        // 1. Faith n-1 disks from t1 to t3 using t2
        toh(n-1, t1, t3, t2);
        
        // 2. Move nth disk from t1 to t2
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        
        // 3. Faith: n-1 disks from t3 to t2 using t1
        toh(n-1, t3, t2, t1);
    }

}
