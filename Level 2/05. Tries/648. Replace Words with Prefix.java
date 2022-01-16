import java.util.*;

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

    public void insert(Node curr, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                curr.add(ch);

            curr = curr.get(ch);
        }
        curr.setTerminal();
    }

    public String search(Node curr, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.isTerminal() == true) {
                return word.substring(0, i);
            }

            if (curr.contains(ch) == false)
                return word;

            curr = curr.get(ch);
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String str) {
        Node root = new Node();
        for (String word : dictionary)
            insert(root, word);

        StringBuilder res = new StringBuilder("");
        for (String word : str.split(" ")) {
            if (res.length() > 0)
                res.append(" ");
            res.append(search(root, word));
        }

        return res.toString();
    }
}