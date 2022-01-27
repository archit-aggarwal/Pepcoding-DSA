/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        // Original Node -> Duplicate Node
        
        Node copyHead = new Node(-1);
        Node tail = copyHead;
        
        // Creation of Deep Copied Linked List
        Node original = head;
        while(original != null){
            Node duplicate = new Node(original.val);  
            tail.next = duplicate;
            tail = duplicate;
            
            hm.put(original, duplicate);
            original = original.next;
        }
        
        // Updating the Random Pointers
        original = head;
        while(original != null){
            Node randomNode = original.random;
            if(randomNode != null){
                randomNode = hm.get(randomNode);
            }
            
            hm.get(original).random = randomNode; 
            original = original.next;
        }
        
        return copyHead.next;
    }
}
