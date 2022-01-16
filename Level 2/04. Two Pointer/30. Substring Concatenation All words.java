class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int words = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i <= s.length() - words * wordLen; i++) {
            String sub = s.substring(i, i + words * wordLen);
            if (isConcat(sub, freq, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isConcat(String sub, Map<String, Integer> freq, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(freq);
    }
}