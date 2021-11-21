// Boxes on Level

import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int currentBox, int n, int k, boolean[] itemPlaced, String boxes, int itemsPlacedCount){
      if(currentBox == n){
          if(itemsPlacedCount == k){
              System.out.println(boxes);
          }
          return;
      }
      
      
      for(int i=0; i<k; i++){
          if(itemPlaced[i] == false){
              itemPlaced[i] = true;
              permutations(currentBox + 1, n, k, itemPlaced, boxes + (i + 1), itemsPlacedCount + 1);
              itemPlaced[i] = false;
          }
      }
      
      // currentBox -> Do not place any element
      permutations(currentBox + 1, n, k, itemPlaced, boxes + 0, itemsPlacedCount);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());
    
    String boxes = "";
    boolean[] itemPlaced = new boolean[k];
    permutations(0, n, k, itemPlaced, boxes, 0);
  }

}
