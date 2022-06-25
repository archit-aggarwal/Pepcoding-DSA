import java.util.*;

class Solution {
    public static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static class FreqComp implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.freq == b.freq) {
                return a.ch - b.ch;
            }

            // Higher Frequency -> Higher Priority
            return (b.freq - a.freq);
        }
    }

    // Time - O(Nlog26), Space - O(26)
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> q = new PriorityQueue<>(new FreqComp());
        for (Character ch : freq.keySet()) {
            q.add(new Pair(ch, freq.get(ch)));
        }

        StringBuilder str = new StringBuilder("");

        while (q.size() > 0) {
            Pair odd = q.remove();
            str.append(odd.ch);
            odd.freq--;

            if (q.size() == 0 && odd.freq > 0) {
                return "";
            }

            if (q.size() > 0) {
                Pair even = q.remove();
                str.append(even.ch);
                even.freq--;

                if (even.freq > 0) {
                    q.add(even);
                }
            }

            if (odd.freq > 0) {
                q.add(odd);
            }
        }

        return str.toString();
    }
}