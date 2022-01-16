class MapSum {
    public static class Node {
        private Node[] children = new Node[26];
        private int val = 0;
        public int pref = 0;

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public int getVal() {
            return val;
        }

        public void add(char ch) {
            children[ch - 'a'] = new Node();
        }

        public void setVal(int val) {
            this.val = val;
        }

        public boolean contains(char ch) {
            return (children[ch - 'a'] != null);
        }
    }

    Node root;

    public MapSum() {
        root = new Node();
    }

    public int search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                return 0;

            curr = curr.get(ch);
        }
        return curr.getVal();
    }

    public void insert(String word, int val) {
        int oldVal = search(word);

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            curr.pref += (val - oldVal);

            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                curr.add(ch);

            curr = curr.get(ch);
        }

        curr.pref += (val - oldVal);
        curr.setVal(val);
    }

    public int sum(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.contains(ch) == false)
                return 0;

            curr = curr.get(ch);
        }
        return curr.pref;
    }
}