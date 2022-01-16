class Solution {
    public static class Node {
        private Node[] children = new Node[26];
        boolean isTerminal = false;

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public void set(char ch) {
            children[ch - 'a'] = new Node();
        }

        public boolean contains(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    public void insert(Node curr, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                curr.set(ch);

            curr = curr.get(ch);
        }
        curr.isTerminal = true;
    }

    String res = "";

    public void DFS(Node curr, String ans) {
        int count = 0;

        if (ans.length() > res.length()) {
            res = ans;
        }

        if (curr.isTerminal == true) {
            return;
        }

        char child = 'a';
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (curr.contains(ch) == true) {
                count++;
                child = ch;
            }
        }

        if (count == 1)
            DFS(curr.get(child), ans + child);
    }

    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for (String str : strs) {
            insert(root, str);
        }

        DFS(root, "");
        return res;
    }
}