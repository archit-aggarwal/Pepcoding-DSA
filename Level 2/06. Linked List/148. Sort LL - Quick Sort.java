class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode(-1);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(-1);
        ListNode rTail = rHead;
        
        while(head != null){
            if(head.val < x){
                lTail.next = head;
                lTail = head;
            } else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }
        
        lTail.next = null;
        rTail.next = null;
        return lHead.next;
    }
    
    public ListNode getTail(ListNode curr){
        if(curr == null) return null;
        while(curr.next != null) curr = curr.next;
        return curr;
    }
    
    public void randomize(ListNode head){
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        int randomIdx = (new Random()).nextInt(size);
        
        curr = head;
        while(randomIdx-- > 0){
            curr = curr.next;
        }
        
        int temp = head.val;
        head.val = curr.val;
        curr.val = temp;
    }
    
    public ListNode sortList(ListNode head) {
        // base case
        if(head == null || head.next == null){
            return head;
        }
        
        randomize(head);
        ListNode left = sortList(partition(head, head.val));
        ListNode right = sortList(head.next);
        head.next = right;
        
        // left -> pivot (head) -> right
        if(left == null) return head;
    
        ListNode leftTail = getTail(left);
        leftTail.next = head;
        return left;
    }
}
