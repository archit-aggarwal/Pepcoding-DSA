import java.util.*;

public class Main {

    public static int solution(String s) {
        // write your code here
        int left = 0, count = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.get(ch) > 1) {
                char chl = s.charAt(left);
                freq.put(chl, freq.get(chl) - 1);
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
