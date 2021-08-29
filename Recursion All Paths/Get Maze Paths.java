import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> res = getMazePaths(0, 0, n-1, m-1);
        System.out.println(res);
    }

    public static ArrayList<String> getMazePaths(int srcRow, int srcCol, int destRow, int destCol) {
        if(srcRow == destRow && srcCol == destCol)
        {
            // Positive Base Case
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }
        else if(srcRow > destRow || srcCol > destCol)
        {
            // Negative Base Case
            ArrayList<String> paths = new ArrayList<>();
            return paths;            
        }
        
        
        // Faith - 1
        ArrayList<String> vpaths = getMazePaths(srcRow + 1, srcCol, destRow, destCol);
        
        // Faith - 2
        ArrayList<String> hpaths = getMazePaths(srcRow, srcCol + 1, destRow, destCol);
        
        // Meeting Expectation
        ArrayList<String> res = new ArrayList<>();
        
        for(String s: hpaths)
            res.add("h" + s);
        
        for(String s: vpaths)
            res.add("v" + s);
        
        return res;
    }

}
