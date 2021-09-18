import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        ArrayList<String> ans = getPerm(str);
        System.out.println(ans.size());
        System.out.println(ans);
        printPermutations(str, "");
    }
    
    public static ArrayList<String> getPerm(String str)
    {
        if(str.equals(""))
        {
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
        
        
        ArrayList<String> curr = new ArrayList<String>();
        for(int i=0; i<str.length(); i++)
        {
            String rem = str.substring(0, i) + str.substring(i + 1);
            ArrayList<String> temp = getPerm(rem);
            
            for(int j=0; j<temp.size(); j++)
                curr.add(str.charAt(i) + temp.get(j));
        }
        
        return curr;
    }
    
    public static void printPermutations(String input, String output) {
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        
        
        // Choices (Edges) for string "abc" are a, b, c
        for(int i=0; i<input.length(); i++)
        {
            char choice = input.charAt(i);
            String newInput = input.substring(0, i) + input.substring(i + 1);
            printPermutations(newInput, output + choice);
        }
        
    }
    
}
