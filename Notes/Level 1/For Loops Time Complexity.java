import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		// O(n)
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}

		// O(n^2)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i + " " + j);
			}
		}

		// O(n^2)
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {

			}
		}

		// O(n^2)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {

			}
		}

		// O(log2 n)
		for (int i = 1; i < n; i *= 2) {

		}

		// O(root n)
		for (int i = 0; i * i < n; i++) {

		}

		// n + n = O(n)
		for (int i = 0; i < n; i++) {

		}
		for (int j = 0; j < n; j++) {

		}

		// n/2 -> O(n)
		for (int i = 0; i < n; i += 2) {

		}

		// 4 + 4 + 4 + .. n times = O(4 * n) = O(n)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {

			}
		}

		// n * log2n = O(n log n)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j *= 2) {

			}
		}
	}

}
