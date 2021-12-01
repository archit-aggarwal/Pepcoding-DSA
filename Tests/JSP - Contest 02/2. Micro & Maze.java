import java.io.*;
import java.util.*;

public class Solution {
public static String helper(int srcRow, int srcCol, int destRow, int destCol, int[][] arr){
        // negative base case
        if(srcRow < 0 || srcCol < 0 || srcRow > destRow || srcCol > destCol || arr[srcRow][srcCol] <= 0){
            return "No";
        }
        
        // positive base case
        if(srcRow == destRow && srcCol == destCol){
            return "Yes";
        }
        
        // Mark cell as visited
        arr[srcRow][srcCol] = -1;
        
        String top =  helper(srcRow - 1, srcCol, destRow, destCol, arr);
        if(top.equals("Yes")) return "Yes";

        String right =  helper(srcRow, srcCol + 1, destRow, destCol, arr);
        if(right.equals("Yes")) return "Yes";
           
        String bottom =  helper(srcRow + 1, srcCol, destRow, destCol, arr);
        if(bottom.equals("Yes")) return "Yes";
           
        String left =  helper(srcRow, srcCol - 1, destRow, destCol, arr);
        if(left.equals("Yes")) return "Yes";
           
        // arr[srcRow][srcCol] = 1;
        
        //       return "Yes";
        
        return "No";
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        System.out.println(helper(0, 0, r - 1, c - 1, arr));
    }
}
