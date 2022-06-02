public static int findIntersection(LinkedList one, LinkedList two) {
        
        Node p1 = one.head;
        Node p2 = two.head;
        
        if(one.size > two.size){
            
            for(int i=1; i<=one.size - two.size; i++){
                p1 = p1.next;
            }
            
        } else if(two.size > one.size){
            for(int i=1; i<=two.size - one.size; i++){
                p2 = p2.next;
            }
        }
        
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1.data;
    }
