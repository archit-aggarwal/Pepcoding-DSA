import java.io.*;
import java.util.*;

public class Solution {

    public static int fact(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();

        int nfact = fact(n);
        int rfact = fact(r);
        int nmrfact = fact(n - r);

        System.out.println(nfact);
        System.out.println((nfact) / (nmrfact));
        System.out.println((nfact) / (nmrfact * rfact));
    }
}