// Level Order - Linewise 
public static void levelOrder(Node node) {
     Queue<Node> q = new ArrayDeque<>();
     q.add(node);
     
     while(q.size() > 0){
         
        int counter = q.size();
        for(int i=0; i<counter; i++){
            
            Node par = q.remove();
            System.out.print(par.data + " ");
            
            if(par.left != null)
                q.add(par.left);
                
            if(par.right != null)
                q.add(par.right);
            
        }
        
        System.out.println();
     }
  }

public static void preorder(Node root){
      if(root == null) return;
      
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
  }
  
  public static void inorder(Node root){
      if(root == null) return;
      
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
  }
  
  public static void postorder(Node root){
      if(root == null) return;
      
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
  }
  
public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

// Iterative Pre, In & Postorder Traversals

  public static void iterativePrePostInTraversal(Node root) {
    Stack<Pair> stk = new Stack<>();
    stk.push(new Pair(root, -1));
    
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> inorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();
    
    while(!stk.isEmpty()){
        Pair par = stk.peek();
        
        if(par.state == -1){
            // preorder
            preorder.add(par.node.data);
                
            if(par.node.left != null){
                stk.push(new Pair(par.node.left, -1));
            }
            par.state++;
            
        } else if(par.state == 0){
            // inorder
            inorder.add(par.node.data);
            
            if(par.node.right != null){
                stk.push(new Pair(par.node.right, -1));
            }
            par.state++;
            
        } else if(par.state == 1){
            // postorder
            postorder.add(par.node.data);
            stk.pop();
        }
    }
    
    for(Integer i: preorder) System.out.print(i + " ");
    System.out.println();
    for(Integer i: inorder) System.out.print(i + " ");
    System.out.println();
    for(Integer i: postorder) System.out.print(i + " ");
    System.out.println();
  }
