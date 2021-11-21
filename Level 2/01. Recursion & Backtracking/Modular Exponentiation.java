import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static long xpown(long x, long n, long mod) {
		if(n == 0) return 1;
		
		long xpownby2 = xpown(x, n / 2, mod);
		
		if(n % 2 == 0) return ((xpownby2 % mod) * (xpownby2 % mod)) % mod;
		else return ((((xpownby2 % mod) * (xpownby2 % mod)) % mod) * (x % mod)) % mod;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long x = scn.nextLong();
		long n = scn.nextLong();

        long ans = xpown(x, n, 1000000007);
        System.out.println(ans);
	}
}
