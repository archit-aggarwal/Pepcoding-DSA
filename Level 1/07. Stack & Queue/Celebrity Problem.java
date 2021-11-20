import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0; i<n; i++){
            stk.push(i);
        }
        
        
        while(stk.size() > 1){
            int v2 = stk.pop();
            int v1 = stk.pop();
            
            if(arr[v1][v2] == 1){
                // v1 janta hai v2 ko => reject v1
                stk.push(v2);
            } else {
                // v1 nahi janta v2 ko => reject v2
                stk.push(v1);
            }
        }
        
        int potCeleb = stk.pop();
        boolean check = true;
        for(int r=0; r<n; r++){
            if(r == potCeleb) continue;
            
            if(arr[r][potCeleb] == 0){
                check = false;
                break;
            }
        }
        
        if(check == false) 
        {
            System.out.println("none");
            return;
        }
        
        for(int c=0; c<n; c++){
            if(c == potCeleb) continue;
            
            if(arr[potCeleb][c] == 1){
                check = false;
                break;
            }
        }
        
        if(check == true){
            System.out.println(potCeleb);
        } else {
            System.out.println("none");
        }
    }

}
