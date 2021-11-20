import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int b1 = scn.nextInt();
    int b2 = scn.nextInt();

    int d = getValue(n, b1, b2);
    System.out.println(d);
 }

 public static int getValue(int n, int b1, int b2){
     int d1 = anyBaseToDecimal(n, b1);
     int d2 = decimalToAnyBase(d1, b2);
     return d2;
 }

 public static int anyBaseToDecimal(int n, int b){
    int rv = 0;

   int p = 1;
   while(n > 0){
       int d = n % 10;
       n = n / 10;
       rv += p * d;
       p = p * b;
   }

    return rv;
}

 public static int decimalToAnyBase(int n, int b){
    int rv = 0;

   int p = 1;
   while(n > 0){
       int d = n % b;
       n = n / b;
       rv += p * d;
       p = p * 10;
   }

    return rv;
}
}
