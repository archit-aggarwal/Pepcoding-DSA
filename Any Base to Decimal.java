import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      int ans = 0;
      int power = 1; //b^0
      
      while(n != 0){
          int ld = n % 10;
          n = n / 10;
          
          ans += (ld * power);
          power *= b;
      }
      return ans;
   }
  }