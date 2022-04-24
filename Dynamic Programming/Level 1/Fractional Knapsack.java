import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair>{
        double price;
        double weight;
        double perKgPrice;
        
        public int compareTo(Pair other){
            // higher perkgprice -> higher priority
            
            if(other.perKgPrice - this.perKgPrice > 0.0) return 1;
            else if(other.perKgPrice - this.perKgPrice == 0.0) return 0;
            else return -1;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++){
            arr[i] = new Pair();
            arr[i].price = scn.nextDouble();
        }
        
        for(int i=0; i<n; i++){
            arr[i].weight = scn.nextDouble();
            arr[i].perKgPrice = arr[i].price / arr[i].weight;
        }
        
        Arrays.sort(arr);
        int cap = scn.nextInt();
        int idx = 0;
        double maxProfit = 0.0;
        
        while(idx < n && cap > 0){
            double price = arr[idx].price;
            double weight = arr[idx].weight;
            idx++;
            
            if(weight <= cap){
                maxProfit += price;
                cap -= weight;
            } else {
                maxProfit +=  (price / weight) * cap;
                cap = 0;
            }
        }
        
        System.out.println(maxProfit);
    }
}
