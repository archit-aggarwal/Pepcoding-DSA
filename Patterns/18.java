import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int stars = n, spaces = 0;
    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=spaces; j++)
            System.out.print("	");
        
        for(int j=1; j<=stars; j++)
        {
            if(i > n/2 || i == 1 || j == 1 || j == stars)
                System.out.print("*	");
            else System.out.print("	");
        }
        System.out.println();
        
        if(i <= n/2) 
        {
            spaces ++;
            stars = stars - 2;
        }
        else
        {
            spaces --;
            stars = stars + 2;
        }
    }
 }
}
