public static void IterativePreandPostOrder(Node root) {
        Stack<Pair> stk = new Stack<>();
        
        Pair rootPair = new Pair(root, -1);
        stk.push(rootPair);
        
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        
        while(stk.size() > 0){
            
            Pair parent = stk.peek(); 
            
            if(parent.state == -1){
                // preorder
                preorder.add(parent.node.data);
                
                // edge pre 
                parent.state++;
                
            } else if(parent.state == parent.node.children.size()){
                // postorder
                postorder.add(parent.node.data);
                stk.pop();
                
            } else {
                // edge
                Pair child = new Pair(parent.node.children.get(parent.state), -1);
                
                stk.push(child);
                // next edge
                parent.state++;
            }
        }
        
        for(Integer i: preorder){
            System.out.print(i + " ");
        }
        
        System.out.println();
        for(Integer i: postorder){
            System.out.print(i + " ");
        }
  }
