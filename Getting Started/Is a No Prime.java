import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int t = scn.nextInt();
    
       for(int i = 1; i <= t; i = i + 1){
           int n = scn.nextInt();
            
            int factors = 0;
            for(int div = 2; div * div <= n; div = div + 1){
                if(n % div == 0){
                    factors = factors + 1;
                    break;
                }
            }
            
            if(factors == 0){
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }
       }    
   }
  }
