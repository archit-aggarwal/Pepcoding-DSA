import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
        // write your code here 
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        
        int dvd = n1;
        int dsr = n2;
        
        while(dvd % dsr != 0)
        {
            int rem = dvd % dsr;
            dvd = dsr;
            dsr = rem;
        }
        
        System.out.println(dsr);
        System.out.println((n1 * n2) / dsr);
     }
    }
