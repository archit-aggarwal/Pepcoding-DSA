import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        
        ListNode oddHead = oddDummy, oddTail = oddDummy;
        ListNode evenHead = evenDummy, evenTail = evenDummy;
        
        ListNode curr = head;
        while(curr != null){
            
            if(curr.val % 2 == 1){
                oddTail.next = curr;
                oddTail = curr;
            } else {
                evenTail.next = curr;
                evenTail = curr;
            }
            curr = curr.next;
        }
        
        if(oddHead.next == null){
            // 0 odd nodes
            return evenHead.next;
            
        } else if(evenHead.next == null){
            // 0 even nodes
            return oddHead.next;
            
        } else {
            
            evenTail.next = oddHead.next;
            oddTail.next = null;
            return evenHead.next;
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
