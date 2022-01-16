class Solution {
    public static class Node {
        Node[] children = new Node[26];
        int prefCount = 0;
        int end = 0;

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public void set(char ch) {
            children[ch - 'a'] = new Node();
        }
    }

    public void insert(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.get(ch) == null) {
                root.set(ch);
            }

            root.prefCount++;
            root = root.get(ch);
        }

        root.prefCount++;
        root.end++;
    }

    public String search(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.prefCount == 1)
                return word.substring(0, i);

            root = root.get(ch);
        }

        return word;
    }

    public String[] prefix(String[] A) {
        Node root = new Node();
        for (String str : A) {
            insert(root, str);
        }

        String[] res = new String[A.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = search(root, A[i]);
        }
        return res;
    }
}
