import java.util.*;
public class Main{
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int spaces = 2*n - 3, stars = 1;
    for(int i=1; i<=n; i++)
    {
        int val = 1;
        for(int j=1; j<=stars; j++)
        {
            System.out.print(val + "\t");
            val ++;
        }
        for(int j=1; j<=spaces; j++)
            System.out.print("\t");
        
        if(i == n) stars--;
        val = stars;
        
        for(int j=1; j<=stars; j++)
        {
            System.out.print(val + "\t");
            val --;
        }
        
        System.out.println();
        stars ++;
        spaces -= 2;
    }
 }
}
