/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
    
    public ListNode middle(ListNode head){
        ListNode slow = head, fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null) // even
            return prev;
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;    
        }
        
        ListNode mid = middle(head);
        ListNode second = reverse(mid.next);
        
        while(head != null && second != null){
            if(head.val != second.val) return false;
            head = head.next;
            second = second.next;
        }
        return true;
    }
}
