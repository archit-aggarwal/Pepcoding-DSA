import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++){
        arr1[i] = scn.nextInt();
    }
    
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++){
        arr2[i] = scn.nextInt();
    }
    
    HashMap<Integer, Boolean> hm = new HashMap<>();
    for(int i=0; i<n1; i++)
        hm.put(arr1[i], true);
    
    for(int i=0; i<n2; i++){
        
        if(hm.containsKey(arr2[i]) == true && 
                hm.get(arr2[i]) == true){
            System.out.println(arr2[i]);
            hm.put(arr2[i], false);
        }
        
    }
 }

}
