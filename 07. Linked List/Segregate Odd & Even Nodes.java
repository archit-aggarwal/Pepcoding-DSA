import java.util.*;

// Method 1: By Using Linked List (Add Last)
public void oddEven(){
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();
        
        while(head != null){
        
            if(head.data % 2 == 1){
                odd.addLast(head.data);
            } else {
                even.addLast(head.data);
            }
            
            removeFirst();
        }
        
        if(even.head == null){
            
            head = odd.head;
            tail = odd.tail;
            tail.next = null;
            
        } else if(odd.head == null) {
            
            head = even.head;
            tail = even.tail;
            tail.next = null;
        }
        else {
            
            odd.tail.next = even.head;
            even.tail.next = null;
            head = odd.head;
            tail = even.tail;    
        }
        
        size = odd.size + even.size;
    }

// Method 2: By Changing Pointers
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
