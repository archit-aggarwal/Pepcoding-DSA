import java.util.*;

public class Main{

public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();
  
  int num = n;
  int nod = 0;
  
  while(num != 0){
      num = num / 10;
      nod++;
  }
  
  int ans = 0;
  for(int i = 1; i <= nod; i++){
      int ld = n % 10;
      n = n / 10;
      
      ans = ans + i * (int)Math.pow(10, ld - 1);
  }
  
  System.out.println(ans);
  
 }
}
