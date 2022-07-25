import java.io.*;
import java.util.*;

public class Main {

   // O(n + k logn)
   public static void approach1(ArrayList<Integer> arr, int k){
        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // o(n)
        pq.addAll(arr);
        
        // o(klogN)
        ArrayList<Integer> res = new ArrayList<>();
        while(k-- > 0)
            res.add(pq.remove());
        
        for(int i=res.size() - 1; i>=0; i--){
            System.out.println(res.get(i));
        }
   }
   
   // O(n log k)
   public static void approach2(ArrayList<Integer> arr, int k){
       // Min heap 
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       
       // O(k logk)
       for(int i=0; i<k; i++){
           pq.add(arr.get(i));
       }
       
       // O((n-k) logk)
       for(int i=k; i<arr.size(); i++){
           
           if(arr.get(i) > pq.peek()){
               pq.remove();
               pq.add(arr.get(i));
           }
       }
       
       while(pq.size() > 0){
           System.out.println(pq.remove());
       }
   }
   
   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      ArrayList<Integer> arr = new ArrayList<>();

      for (int i = 0; i < n; i++) {
         int x = scn.nextInt();
         arr.add(x);
      }

      int k = scn.nextInt();
      // write your code here
      approach2(arr, k);
    }

}
