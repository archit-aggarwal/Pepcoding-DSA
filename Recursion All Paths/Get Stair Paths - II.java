import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        ArrayList<String> res = getStairPaths(n);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
    
        if(n == 0)
        {
            // Positive Base Case : 1 Path Possible
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        // Only Edges leading to success are taken into account
        // hence no need to handle failure (negative base case).
      
        if(n - 1 >= 0)
        {
            ArrayList<String> futurePaths1 = getStairPaths(n - 1);
            for(String s1: futurePaths1)
                res.add(1 + s1);
        }
        
        if(n - 2 >= 0)
        {
            ArrayList<String> futurePaths2 = getStairPaths(n - 2);
            for(String s2: futurePaths2)
                res.add(2 + s2);
        }
        
        if(n - 3 >= 0)
        {
            ArrayList<String> futurePaths3 = getStairPaths(n - 3);
            for(String s3: futurePaths3)
                res.add(3 + s3);
        }
        
        return res;
    }

}
