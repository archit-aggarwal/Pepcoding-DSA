import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
      
        int spaces = 0, stars = n;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= spaces; j++)
                System.out.print("\t");
            for(int j = 1; j <= stars; j++)
                System.out.print("*\t");
            
            System.out.println();
            spaces++;
            stars--;
        }

    }
}
