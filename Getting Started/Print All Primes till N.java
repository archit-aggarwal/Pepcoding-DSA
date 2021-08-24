import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int lo = scn.nextInt();
        int hi = scn.nextInt();
        
        for(int n = lo; n <= hi; n++){
            int factors = 0;
            for(int div = 2; div * div <= n; div = div + 1){
                if(n % div == 0){
                    factors = factors + 1;
                    break;
                }
            }
            
            if(factors == 0){
                System.out.println(n);
            }
        }
    }
}
