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
