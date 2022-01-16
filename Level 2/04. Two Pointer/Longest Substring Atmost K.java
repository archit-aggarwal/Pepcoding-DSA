import java.util.*;

public class Main {

    public static int solution(String str, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = 0, left = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() > k) {
                char chl = str.charAt(left);
                freq.put(chl, freq.getOrDefault(chl, 0) - 1);

                if (freq.get(chl) == 0) {
                    freq.remove(chl);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }

}
