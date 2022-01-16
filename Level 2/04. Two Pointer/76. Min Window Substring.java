class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("") == true || s.equals("") == true
                || s.length() < t.length())
            return "";

        HashMap<Character, Integer> req = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            req.put(ch, req.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> curr = new HashMap<>();
        int matchCount = 0, l = 0;
        int idx = 0, len = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            int freq = curr.getOrDefault(ch, 0) + 1;
            curr.put(ch, freq);

            if (freq == req.getOrDefault(ch, 0)) {
                matchCount++;
            }

            while (matchCount >= req.size()) {
                if (matchCount >= req.size() && r - l < len) {
                    idx = l;
                    len = r - l + 1;
                }

                char chl = s.charAt(l);
                int freql = curr.get(chl) - 1;
                curr.put(chl, freql);

                if (freql + 1 == req.getOrDefault(chl, 0)) {
                    matchCount--;
                }
                l++;
            }
        }

        if (len == Integer.MAX_VALUE)
            return "";
        return s.substring(idx, idx + len);
    }
}