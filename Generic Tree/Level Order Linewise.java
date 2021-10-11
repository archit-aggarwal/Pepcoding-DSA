public static void levelorder1(Node root){
    Queue<Node> mainQ = new ArrayDeque<>();
    mainQ.add(root);
      
    
    while(mainQ.size() > 0){
        Queue<Node> childQ = new ArrayDeque<>();
        
        while(mainQ.size() > 0){
            // Do work of one level
            
            Node curr = mainQ.remove();
            System.out.print(curr.data + " ");
            
            for(Node child: curr.children){
                childQ.add(child);
            }
        }
        
        System.out.println();
        mainQ = childQ;
    }
  }
  
  public static void levelorder2(Node root){
      Queue<Node> q = new ArrayDeque<>();
      Node dummy = new Node();
      dummy.data = -1;
      
      q.add(root);
      q.add(dummy);
      
      while(q.size() > 0){
          
          Node curr = q.remove();
          
          if(curr.data == -1){
              // dummy node -> delimeter
              
              System.out.println();
              
              if(q.size() > 0){
                q.add(dummy);
              }
              
          } else {
              
              System.out.print(curr.data + " ");
              for(Node child: curr.children){
                    q.add(child);   
              }
          }
      }
  }
  
  public static void levelorder3(Node root){
    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    
    while(q.size() > 0){
        // Pop 1 Node
        
        int counter = q.size();
        for(int i=0; i<counter; i++){
            Node curr = q.remove();
            System.out.print(curr.data + " ");
        
            // Push Children in Queue
            for(Node child: curr.children){
                q.add(child);
            }
        }
        
        System.out.println();        
    }
  }
