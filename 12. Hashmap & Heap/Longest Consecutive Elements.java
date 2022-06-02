import java.io.*;
import java.util.*;

public class Main{
// Time Complexity - O(n), Space Complexity - O(n)
public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    HashMap<Integer, Boolean> hm = new HashMap<>();
    for(int i=0; i<n; i++){
        int x = scn.nextInt();
        hm.put(x, true);
    }
    
    int maxChain = 0;
    int startingPt = 0;
    
    for(Integer key: hm.keySet()){
        
        if(hm.containsKey(key - 1) == false){
            // chain starting pt
            
            int length = 1;
            while(hm.containsKey(key + length) == true){
                length++;
            }
            
            if(length > maxChain){
                maxChain = length;
                startingPt = key;
            }
        }
    }
    
    for(int i=0; i<maxChain; i++){
        System.out.println(startingPt + i);
    }
 }
}
