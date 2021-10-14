public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList l3 = new LinkedList();
            
            Node p1 = l1.head, p2 = l2.head;
            
            while(p1 != null && p2 != null){
                if(p1.data < p2.data){
                    
                    int val = p1.data;
                    l3.addLast(val);
                    p1 = p1.next;
                    
                } else {

                    int val = p2.data;
                    l3.addLast(val);
                    p2 = p2.next;
                    
                }
            }
            
            while(p1 != null){
                int val = p1.data;
                l3.addLast(val);
                p1 = p1.next;                
            }
            
            while(p2 != null){
                int val = p2.data;
                l3.addLast(val);
                p2 = p2.next;                
            }
            
            return l3;
        }

public static LinkedList mergeSort(Node head, Node tail)
    {
        if(head == null){
            // 0 node
            LinkedList base = new LinkedList();
            return  base;    
        }
        
        if(head == tail){
            // 1 node
            LinkedList base = new LinkedList();
            base.addLast(head.data);
            return base;
        }
        
        Node mid = midNode(head, tail);
        
        // faith
        LinkedList l1 = mergeSort(head, mid);
        LinkedList l2 = mergeSort(mid.next, tail);
        
        // meeting expectation
        LinkedList l3 = mergeTwoSortedLists(l1, l2);
        return l3;
    }
