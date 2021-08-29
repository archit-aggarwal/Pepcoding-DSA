import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> res = getMazePaths(0, 0, n-1, m-1);
        System.out.println(res);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
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
        
        ArrayList<String> res = new ArrayList<>();
        
        // Horizontal
        for(int i=1; srcCol + i <= destCol; i++)
        {
            ArrayList<String> hpaths = getMazePaths(srcRow, srcCol + i, destRow, destCol);
            for(String s: hpaths)
                res.add("h" + i + s);
        }
        
        // Vertical
        for(int i=1; srcRow + i <= destRow; i++)
        {
            ArrayList<String> vpaths = getMazePaths(srcRow + i, srcCol, destRow, destCol);
            for(String s: vpaths)
                res.add("v" + i + s);
        }
        
        // Diagonal
        for(int i=1; srcCol + i <= destCol && srcRow + i <= destRow; i++)
        {
            ArrayList<String> dpaths = getMazePaths(srcRow + i, srcCol + i, destRow, destCol);
            for(String s: dpaths)
                res.add("d" + i + s);
        }
        
        return res;
    }

}
