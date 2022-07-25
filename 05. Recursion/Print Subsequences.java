import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        String output = "";
        printSS(input, output);
    }

    public static void printSS(String input, String output) {
        if(input.length() == 0)
        {
            // Base Case: Just Print then return,
            // -> Enjoy, no need to return any arraylist
            System.out.println(output);
            return;
        }
        
        
        // First Character
        char ch = input.charAt(0);
        
        // 1. Character Present in Subsequence
        printSS(input.substring(1), output + ch);
        
        // 2. Character Not Present in Subsequence
        printSS(input.substring(1), output);
    }

}


// Method 2: Using ArrayList
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        ArrayList<Character> subSet = new ArrayList<>();
        printSS(str, 0, subSet);
    }

    public static void printSS(String str, int idx, ArrayList<Character> subSet) {
        if(idx == str.length()){
            for(Character i: subSet){
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        
        // yes
        subSet.add(str.charAt(idx));
        printSS(str, idx + 1, subSet);
        
        subSet.remove(subSet.size() - 1);
        printSS(str, idx + 1, subSet);
    }

}
