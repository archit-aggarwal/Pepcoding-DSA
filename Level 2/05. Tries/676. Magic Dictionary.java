class MagicDictionary {
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

    Node root;

    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.contains(ch) == false)
                    curr.add(ch);

                curr = curr.get(ch);
            }
            curr.setTerminal();
        }
    }

    public boolean search(String word, int idx, Node curr, boolean change) {
        if (idx == word.length()) {
            if (change == true && curr.isTerminal() == true)
                return true;
            return false;
        }

        char ch = word.charAt(idx);
        if (curr.contains(ch) == true && search(word, idx + 1, curr.get(ch), change))
            return true;

        if (change == true)
            return false;

        for (char chn = 'a'; chn <= 'z'; chn++) {
            if (chn == ch)
                continue;

            if (curr.contains(chn) && search(word, idx + 1, curr.get(chn), true)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(String searchWord) {
        return search(searchWord, 0, root, false);
    }
}
