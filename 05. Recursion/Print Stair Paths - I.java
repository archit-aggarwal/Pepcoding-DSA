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
        else if(input < 0)
        {
            // Negative Base Case
            return;
        }
        
        // All paths explored, hence, both types of base cases required.
        
        printStairPaths(input - 1, output + 1);
        printStairPaths(input - 2, output + 2);
        printStairPaths(input - 3, output + 3);
    }

}
