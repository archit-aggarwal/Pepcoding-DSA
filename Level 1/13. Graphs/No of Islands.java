import java.io.*;
import java.util.*;

public class Main {
   public static void dfs(int[][] arr, int srcRow, int srcCol){
        if(srcRow < 0 || srcRow >= arr.length || srcCol < 0 
            || srcCol >= arr[0].length || arr[srcRow][srcCol] != 0){
            // invalid cell or already visited island cell or water cell
            return;
        }  
        
        arr[srcRow][srcCol] = -1;
        
        dfs(arr, srcRow + 1, srcCol);
        dfs(arr, srcRow - 1, srcCol);
        dfs(arr, srcRow, srcCol + 1);
        dfs(arr, srcRow, srcCol - 1);
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
        
      int islands = 0;
      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
              
              if(arr[i][j] != -1 && arr[i][j] != 1) // neither visited nor water cell{
              {
                  // unvisited island cell
                  dfs(arr, i, j);
                  islands++;
              }      
              
          }
      }
      System.out.println(islands);
   }

}
