class Solution {
    public static class Node {
        private Node[] children = new Node[26];
        private boolean isTerminal = false;

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public boolean isTerminal() {
            return isTerminal;
        }

        public void setTerminal() {
            isTerminal = true;
        }

        public void add(char ch) {
            children[ch - 'a'] = new Node();
        }

        public boolean contains(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    public void insert(String word, Node curr) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                curr.add(ch);

            curr = curr.get(ch);
        }
        curr.setTerminal();
    }

    String res = "";

    public void DFS(Node root, String ansSofar) {
        if (root.isTerminal() == false)
            return;

        if (ansSofar.length() > res.length())
            res = ansSofar;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (root.contains(ch) == true) {
                DFS(root.get(ch), ansSofar + ch);
            }
        }
    }

    public String longestWord(String[] words) {
        Node root = new Node();
        for (String word : words)
            insert(word, root);

        root.setTerminal();

        DFS(root, "");
        return res;
    }
}