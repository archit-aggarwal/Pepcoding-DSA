import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(freq.containsKey(ch)){
                int oldFreq = freq.get(ch);
                freq.put(ch, oldFreq + 1);
            }
            else {
                freq.put(ch, 1);
            }
        }
        
        char ch = str.charAt(0);
        int maxFreq = freq.get(ch);
        
        for(Character key: freq.keySet()){
            int currFreq = freq.get(key);
            
            if(currFreq > maxFreq){
                ch = key;
                maxFreq = currFreq;
            }
        }
        
        System.out.println(ch);
    }

}
