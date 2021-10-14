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
