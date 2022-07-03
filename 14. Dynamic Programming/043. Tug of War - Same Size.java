// NADOS: https://nados.io/question/tug-of-war?zen=true

import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        helper(arr, 0, "", 0, 0, "", 0, 0);
        System.out.println("[" + s1Ans + "] [" + s2Ans + "]");
    }

    static int mindiff = Integer.MAX_VALUE;
    static String s1Ans = "", s2Ans = "";

    public static void helper(int[] arr, int idx, String s1, int s1Sum, int s1Len, String s2, int s2Sum, int s2Len) {
        if (idx == arr.length) {
            int diff = Math.abs(s1Sum - s2Sum);

            if (arr.length % 2 == 1 && (s1Len == s2Len + 1 || s2Len == s1Len + 1) && diff < mindiff) {
                s1Ans = s1.substring(2);
                s2Ans = s2.substring(2);
                mindiff = diff;
            }

            else if (arr.length % 2 == 0 && s1Len == s2Len && diff < mindiff) {
                s1Ans = s1.substring(2);
                s2Ans = s2.substring(2);
                mindiff = diff;
            }

            return;
        }

        // Element is inserted in S1
        helper(arr, idx + 1, s1 + ", " + arr[idx], s1Sum + arr[idx], s1Len + 1, s2, s2Sum, s2Len);

        // Element in inserted in S2
        helper(arr, idx + 1, s1, s1Sum, s1Len, s2 + ", " + arr[idx], s2Sum + arr[idx], s2Len + 1);
    }

}