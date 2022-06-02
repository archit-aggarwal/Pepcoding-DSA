import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int stars = 1, spaces = n/2, val = 1;
        for(int i=1; i<=n; i++)
        {
            int temp = val;
            
            for(int j=1; j<=spaces; j++)
                System.out.print("	");
            
            for(int j=1; j<=stars; j++)
            {
                System.out.print(temp + "	");
                if(j <= stars/2)
                    temp++;
                else temp--;
            }
            
            System.out.println();
            if(i <= n/2)
            {
                stars += 2;
                spaces--;
                val ++;
            }
            else
            {
                stars -= 2;
                spaces++;
                val --;
            }
        }
    }
}
