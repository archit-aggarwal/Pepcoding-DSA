import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String output = "";
        printKPC(input, output);
    }
    static String[] keypad = {".;", "abc", "def", 
        "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };
    
    public static void printKPC(String input, String output)     {
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        
        char ch = input.charAt(0);
        
        // for(char letter: keypad[ch - '0'].toCharArray())
        // Below for loop can be converted with above for each loop.
        
        for(int i=0; i<keypad[ch - '0'].length(); i++)
        {
            char letter = keypad[ch - '0'].charAt(i);
            printKPC(input.substring(1), output + letter);
        }
    }

}
