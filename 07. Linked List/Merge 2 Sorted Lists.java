import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
                
            } else {
                
                tail.next = l2;
                tail = l2;
                l2 = l2.next;                
                
            }
            
        }
        
        if(l1 != null) tail.next = l1;
        else tail.next = l2;
        
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        int m = scn.nextInt();
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}
