public static void traversals(Node root) {
    System.out.println("Node Pre " + root.data);
    
    for(Node child: root.children){
        System.out.println("Edge Pre " + root.data + "--" + child.data);
        traversals(child);
        System.out.println("Edge Post " + root.data + "--" + child.data);
    }
    
    System.out.println("Node Post " + root.data);
  }

public static void levelOrder(Node root){
        Queue<Node> q = new ArrayDeque<>();
        
        q.add(root);
        
        while(q.size() > 0){
            // Pop 1 Node
            Node curr = q.remove();
            System.out.print(curr.data + " ");
        
            // Push Children in Queue
            for(Node child: curr.children){
                q.add(child);
            }
        }
        
        System.out.print(".");
}

