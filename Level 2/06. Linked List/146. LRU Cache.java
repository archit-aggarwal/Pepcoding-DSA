class LRUCache {
    public static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int size = 0, capacity;
    Node head, tail;
    HashMap<Integer, Node> hm;
        
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        if(hm.containsKey(key) == false)
            return -1;
        
        Node curr = hm.get(key);
        
        // Remove At
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        // Add First
        curr.prev = head;
        curr.next = head.next;
        curr.prev.next = curr;
        curr.next.prev = curr;
        
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key) == false){
            // Insert
            Node curr = new Node(key, value);
            
            if(size == capacity){
                // Remove Last
                Node temp = tail.prev;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                hm.remove(temp.key);
                
            } else size++;
            
            // Add First
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
            hm.put(key, curr);
            
        } else {
            // Update
            Node curr = hm.get(key);
        
            // Remove At
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            // Add First
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
            
            curr.val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
