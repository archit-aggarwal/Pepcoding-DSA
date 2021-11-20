import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        // Base Case
        if(str.length() == 0)
        {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        
        
        ArrayList<String> sres = gss(str.substring(1));
        ArrayList<String> res = new ArrayList<>();
        
        for(String s: sres)
        {
            // Append ""
            res.add("" + s);
        }
        
        for(String s: sres)
        {
            // Append first character 
            res.add(str.charAt(0) + s);
        }
        
        return res;
    }

}
