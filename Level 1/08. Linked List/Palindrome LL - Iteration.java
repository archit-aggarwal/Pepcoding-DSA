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
    
    public static boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode mid = getMid(head);
        ListNode second = reverse(mid.next);
        mid.next = null;
        
        while(second != null){
            if(first.val != second.val)
                return false;
            
            first = first.next;
            second = second.next;
        }
        return true;
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

        System.out.println(isPalindrome(dummy.next));
    }
}
