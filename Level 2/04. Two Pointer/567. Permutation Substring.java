class Solution {
    public boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] reqFreq = new int[26];
        int window = s1.length();

        for (int i = 0; i < window; i++)
            reqFreq[s1.charAt(i) - 'a']++;

        int[] currFreq = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            currFreq[s2.charAt(i) - 'a']++;

            if (i >= window) {
                currFreq[s2.charAt(i - window) - 'a']--;
            }

            if (isEqual(reqFreq, currFreq) == true) {
                return true;
            }
        }
        return false;
    }
}