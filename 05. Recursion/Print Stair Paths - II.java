import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        String output = "";
        printStairPaths(input, output);
    }

    public static void printStairPaths(int input, 
                                String output) {
        if(input == 0)
        {
            // Positive Base Case
            System.out.println(output);
            return;
        }
        
        // Har kadam soch samajh kar rakha hai, khai me kabhi nahi girenge
        // no need of negative base case, because edges leading to them are removed
      
        if(input - 1 >= 0)
            printStairPaths(input - 1, output + 1);
        
        if(input - 2 >= 0)
            printStairPaths(input - 2, output + 2);
        
        if(input - 3 >= 0)
            printStairPaths(input - 3, output + 3);
    }

}
