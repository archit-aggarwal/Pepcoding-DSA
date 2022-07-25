import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    long prev0 = 1l, prev1 = 1l;
    for(int i=2; i<=n; i++)
    {
        long curr0 = prev1;
        long curr1 = prev0 + prev1;
        prev0 = curr0; prev1 = curr1;
    }
    
    System.out.println((prev0 + prev1) * (prev0 + prev1));
 }

}
