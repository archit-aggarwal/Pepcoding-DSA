import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
       
        // sort intervals based on starting time.
        Arrays.sort(arr, (a, b) -> { return a[0] - b[0]; });
      
     
        Stack<Integer[]> stk = new Stack<>();
        
        for(int i=0; i<arr.length; i++)
        {
            int start = arr[i][0];
            int end = arr[i][1];
            
            if(stk.empty())
            {
                // first interval
                Integer[] ans = {start, end};
                stk.push(ans);
            }
            else
            {
                Integer[] prevInterval = stk.pop();
                if(start <= prevInterval[1])
                {
                    // overlapping -> merge
                    prevInterval[1] = Math.max(end, prevInterval[1]);
                    stk.push(prevInterval);
                } 
                else
                {
                    // new Interval
                    stk.push(prevInterval);
                    Integer[] ans = {start, end};
                    stk.push(ans);    
                }
            }
        }
        
        // Stack Elements are in reverse order.
        Stack<Integer[]> res = new Stack<>();
        while(!stk.isEmpty())
            res.push(stk.pop());
        
        while(!res.isEmpty())
        {
            Integer[] curr = res.pop();
            System.out.println(curr[0] + " " + curr[1]);
        }
    }

}
