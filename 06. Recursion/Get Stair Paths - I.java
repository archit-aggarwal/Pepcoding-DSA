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
        if(n < 0)
        {
            // Negative Base Case : No Path Possible
            ArrayList<String> paths = new ArrayList<>();
            return paths;
        }
        else if(n == 0)
        {
            // Positive Base Case : 1 Path Possible
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }
        
        // Lets go with the flow. We will see both success and failure in our 
        // journey. No worries, let's explore all paths, we will handle success
        // and failure with complete courage.
      
        // Faith
        ArrayList<String> futurePaths1 = getStairPaths(n - 1);
        ArrayList<String> futurePaths2 = getStairPaths(n - 2);
        ArrayList<String> futurePaths3 = getStairPaths(n - 3);
        
        // Meeting Expectation
        ArrayList<String> res = new ArrayList<>();
        for(String s1: futurePaths1)
            res.add(1 + s1);
        for(String s2: futurePaths2)
            res.add(2 + s2);
        for(String s3: futurePaths3)
            res.add(3 + s3);
        
        return res;
    }

}
