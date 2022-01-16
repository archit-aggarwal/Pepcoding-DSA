import java.util.*;

class Solution {
    public static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;

        public boolean contains(char ch) {
            return (children[ch - 'a'] != null);
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public void set(char ch) {
            children[ch - 'a'] = new Node();
        }

        public boolean getEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    public void insert(Node root, String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                curr.set(ch);

            curr = curr.get(ch);
        }

        curr.setEnd();
    }

    public void DFS(Node root, String ssf, List<String> ans, int k) {
        if (ans.size() == k)
            return;

        if (root.getEnd() == true) {
            ans.add(ssf);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (root.contains(ch) == true) {
                DFS(root.get(ch), ssf + ch, ans, k);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String word : products)
            insert(root, word);

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);

            if (root.contains(ch) == true) {
                root = root.get(ch);
                List<String> ans = new ArrayList<>();
                DFS(root, searchWord.substring(0, i + 1), ans, 3);

                res.add(ans);
            } else
                break;
        }

        while (res.size() < searchWord.length()) {
            res.add(new ArrayList<>());
        }
        return res;
    }
}