import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head){
        
        ListNode prev = null, curr = head, ahead = head.next;
        
        while(curr != null){
            
            curr.next = prev;
            
            prev = curr;
            curr = ahead;
            
            if(ahead != null)
                ahead = ahead.next;
        }
        
        return prev;
    }
    
    public static void unfold(ListNode head) {
        if(head == null || head.next == null
            || head.next.next == null){
            return;
        }
        
        ListNode l1 = head, t1 = head;
        ListNode l2 = head.next, t2 = head.next;
        
        while(t1.next != null && t2.next != null){
            
            t1.next = t1.next.next;
            
            if(t2.next != null)
                t2.next = t2.next.next;
                
            t1 = t1.next;
            t2 = t2.next;
        }
        
        l2 = reverse(l2);
        t1.next = l2;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
