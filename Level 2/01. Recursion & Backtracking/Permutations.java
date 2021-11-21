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

// Item on Level
import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
    // write your code here
    if(ci == ti){
        for(int val: boxes) System.out.print(val);
        System.out.println();
    }
    
    // Item -> Chose box
    for(int i=0; i<boxes.length; i++){
        if(boxes[i] == 0){
            boxes[i] = ci + 1;
            permutations(boxes, ci + 1, ti);
            boxes[i] = 0;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 0, ritems);
  }

}

// Items = Boxes
class Solution {
    List<List<Integer>> res;
    int[] nums;
    
    public void permutations(int currentBox, boolean[] itemPlaced, List<Integer> boxes){
      if(currentBox == nums.length){
          List<Integer> copy = new ArrayList<>(boxes);
          res.add(copy);
          return;
      }
      
      // currentBox -> (YES) Place any unplaced item
      for(int i=0; i<nums.length; i++){
          if(itemPlaced[i] == false){
              itemPlaced[i] = true;
              boxes.add(nums[i]);
              
              permutations(currentBox + 1, itemPlaced, boxes);
              
              boxes.remove(boxes.size() - 1);
              itemPlaced[i] = false;
          }
      }
  }
    
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        
        permutations(0, new boolean[nums.length], new ArrayList<>());
        return res;
    }
}

// Using Swap Method
class Solution {
    List<List<Integer>> res;
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void permutations(int currentBox, int[] nums){
      if(currentBox == nums.length){
          List<Integer> copy = new ArrayList<>();
          for(int i=0; i<nums.length; i++){
              copy.add(nums[i]);
          }
          res.add(copy);
          return;
      }
      
      // currentBox -> (YES) Place any unplaced item
      for(int i=currentBox; i<nums.length; i++){
          swap(nums, currentBox, i);
          permutations(currentBox + 1, nums);
          swap(nums, currentBox, i);
      }
  }
    
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        
        permutations(0, nums);
        return res;
    }
}
