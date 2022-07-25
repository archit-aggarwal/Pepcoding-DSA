import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String output = "";
        printEncodings(input, output);
    }

    public static void 
            printEncodings(String input, String output) {
        if(input.length() == 0)
        {
            System.out.println(output);
            return;
        }
        
        // 1. Extract one character from input
        char ch1 = input.charAt(0);
        if(ch1 >= '1' && ch1 <= '9')
            printEncodings(input.substring(1), output + (char)(ch1 - '0' + 96));
        
        
        if(input.length() > 1) 
        // Two characters can only be extracted only if there are atleast 2 characters present
        {
            // 2. Extract two characters from input
            String ch12 = input.substring(0, 2);
            int ch12Int = Integer.parseInt(ch12);
            
            // Condition for ch12 in "10" - "26"
            if(ch12Int >= 10 && ch12Int <= 26)
                printEncodings(input.substring(2), output + (char)(ch12Int + 96));
        }
        
    }

}
