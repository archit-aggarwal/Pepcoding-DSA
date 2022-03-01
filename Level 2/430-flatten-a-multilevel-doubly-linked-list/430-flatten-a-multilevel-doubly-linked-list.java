/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public void makeChildNull(Node head){
        while(head != null){
            head.child = null;
            head = head.next;
        }
    }
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Stack<Node> stk = new Stack<>();
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        while(stk.size() > 0 || head != null){
            if(head != null){
                if(head.next != null)
                    stk.push(head.next);
                
                tail.next = head;
                head.prev = tail;
                tail = head;
                head = head.child;
            }
            else head = stk.pop();
        }
        
        tail.next = null;
        dummy.next.prev = null;
        makeChildNull(dummy.next);
        return dummy.next;
    }
}