import java.io.*;
import java.util.*;

public class Solution {
    
    public static void helper(String s, String output, ArrayList<String> ans){
        if(s.equals("") == true){
            ans.add(output);
            return;
        }

        helper(s.substring(1), output, ans);
        helper(s.substring(1), output + s.charAt(0), ans);
        helper(s.substring(1), output + (int)s.charAt(0), ans);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        ArrayList<String> ans = new ArrayList<>();
        helper(s, "", ans);
        System.out.println(ans.size());
        System.out.println(ans);
        
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
