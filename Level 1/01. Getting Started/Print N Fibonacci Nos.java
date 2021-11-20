import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // write your code here
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      
      // Initializing Three pointers
      int a = 0, b = 1, c = 1;
      
      for(int i=0; i<n; i++)
      {
          System.out.println(a);
          
          // Moving Three Pointer
          a = b;
          b = c;
          c = a + b;
      }
   }
  }
