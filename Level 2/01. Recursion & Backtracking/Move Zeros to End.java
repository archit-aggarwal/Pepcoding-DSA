import java.util.*;
 
 public class Main {
 
     public static void moveZeroes(int idx, int countOfNonZero, int[] nums) {
        if(idx == nums.length){
            int countOfZeros = nums.length - countOfNonZero;
            for(int i=0; i<countOfZeros; i++){
                nums[nums.length - 1 - i] = 0;
            }
            return;
        }
        
        if(nums[idx] != 0){
            nums[countOfNonZero] = nums[idx];
            moveZeroes(idx + 1, countOfNonZero + 1, nums);
        } 
        else {
            moveZeroes(idx + 1, countOfNonZero, nums);
        }
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int[] arr = new int[N];
 
         for (int i = 0; i < arr.length; i++) {
             arr[i] = sc.nextInt();
         }
 
         moveZeroes(0, 0, arr);
         display(arr);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 }
