import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
        int[] gas = new int[petrolpumps.size()];
        int[] cost = new int[petrolpumps.size()];
        for(int i=0;i<gas.length;i++){
            gas[i] = petrolpumps.get(i).get(0);
        }
        for(int i=0;i<cost.length;i++){
            cost[i] = petrolpumps.get(i).get(1);
        }
        int n = gas.length;
        
        int extra = 0;
        int start = 0;
        int deficit = 0;
        
        for(int i=0;i<n;i++){
            extra += (gas[i] - cost[i]);
            if(extra<0) {
                start = i + 1;
                deficit -= extra;
                extra = 0;
            }
        }
        
        if(extra>=deficit) return start;
        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] petrolpumpsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> petrolpumpsRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowTempItems[j]);
                petrolpumpsRowItems.add(petrolpumpsItem);
            }

            petrolpumps.add(petrolpumpsRowItems);
        }

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
