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
    
    public static ListNode getMid(ListNode head) {
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static void fold(ListNode head) {
        ListNode mid = getMid(head);
        ListNode l1 = head;
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        while(curr2 != null) {
            ListNode curr1next = curr1.next;
            ListNode curr2next = curr2.next;
            
            curr1.next = curr2;
            curr2.next = curr1next;
            
            curr1 = curr1next;
            curr2 = curr2next;
        }
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
        fold(head);
        printList(head);
    }
}
