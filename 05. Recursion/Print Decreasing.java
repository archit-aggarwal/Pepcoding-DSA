import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        // Base Case
        if(n == 0) return;
        
        // 1st statement -> Work -> Print
        System.out.println(n);
        
        // 2nd statement -> Faith 
        printDecreasing(n - 1);
    }

}
