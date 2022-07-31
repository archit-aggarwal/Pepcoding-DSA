// CodeStudio (Coding Ninjas) Leetcode Locked:
// https://www.codingninjas.com/codestudio/problems/smallest-equivalent-string_1381859

// Time = O(L * 26) Where L = String Length

class Solution {
    public static int parent[] = new int[26];

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i <= j)
            parent[j] = i;
        else
            parent[i] = j;
    }

    public static int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public static String smallestString(String s, String t, String str) {
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (int i = 0; i < s.length(); i++)
            union(s.charAt(i) - 'a', t.charAt(i) - 'a');

        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char ch = (char) (find(str.charAt(i) - 'a') + 'a');
            res.append(ch);
        }

        return res.toString();
    }
}
