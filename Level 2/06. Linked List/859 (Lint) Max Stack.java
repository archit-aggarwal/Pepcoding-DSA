class MaxStack {
    public static class Node{
        int val;
        Node prev;
        Node next;
        Node(int val) {this.val = val;}
        Node(int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    TreeMap<Integer, ArrayList<Node>> map;
    Node head, tail;

    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }
  
    public void push(int x) {
        // Insert At Last in DLL
        Node curr = new Node(x, tail.prev, tail);
        tail.prev.next = curr;
        tail.prev = curr;

        // Insert in TreeMap
        if(map.containsKey(x) == false){
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(curr);
    }

    public int pop() {
        // Delete Last Element From DLL
        Node curr = tail.prev;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        // Delete Node From TreeMap
        ArrayList<Node> arr = map.get(curr.val);
        arr.remove(arr.size() - 1);
        if(arr.size() == 0) map.remove(curr.val);
        else map.put(curr.val, arr);
        return curr.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastEntry().getKey();
    }

    public int popMax() {
        int maxVal = peekMax();
        ArrayList<Node> arr = map.get(maxVal);
        Node curr = arr.get(arr.size() - 1);

        // Delete Last Element From DLL
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        // Delete Node From TreeMap
        arr.remove(arr.size() - 1);
        if(arr.size() == 0) map.remove(curr.val);
        else map.put(curr.val, arr);
        return curr.val;
    }
}
