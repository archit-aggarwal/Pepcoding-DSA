// GfG: https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0

import java.util.*;

// Time - O(NLogK + KLogK), Space - O(K) Extra Space
class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = scn.nextInt();

			PriorityQueue<Integer> q = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				q.add(arr[i]);
				if (i >= k) {
					System.out.print(q.remove() + " ");
				}
			}

			while (q.size() > 0) {
				System.out.print(q.remove() + " ");
			}

			System.out.println();
		}

		scn.close();
	}
}