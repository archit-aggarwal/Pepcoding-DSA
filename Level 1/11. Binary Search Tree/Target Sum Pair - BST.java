public static void approach2Helper(Node root, ArrayList<Integer> arr){
    if(root == null) return;
    
    approach2Helper(root.left, arr);
    arr.add(root.data);
    approach2Helper(root.right, arr);
  }
  public static void approach2(Node root, int target){
    ArrayList<Integer> arr = new ArrayList<>(); // o(n) space 
    approach2Helper(root, arr); // insert elements in sorted order in arraylist - O(n)
    
    // Two Pointer on arraylist - o(n)
    int left = 0, right = arr.size() - 1;
    
    while(left < right){
        int sum = arr.get(left) + arr.get(right);
        if(sum == target){
            System.out.println(arr.get(left) + " " + arr.get(right));
            left++; right--;
        } else if(sum < target){
            left++;
        } else {
            right--;
        }
    }
  }
  
  public static boolean find(Node curr, int target){
    if(curr == null) return false;
    if(curr.data == target) return true;
    
    if(curr.data < target) return find(curr.right, target);
    return find(curr.left, target);
  }
  public static void approach1Helper(Node curr, int target, Node root){
      if(curr == null) return;
      
      approach1Helper(curr.left, target, root);
      
      if(curr.data >= target/2) return;
      
      int complement = target - curr.data;
      if(find(root, complement) == true){
          System.out.println(curr.data + " " + complement);
      }
      
      approach1Helper(curr.right, target, root);
  }
  public static void approach1(Node root, int target){
     approach1Helper(root, target, root);
  }
  
// O(n) time, O(h) stack space
  public static void approach3(Node root, int target){
      Stack<Pair> inorder = new Stack<>();
      inorder.push(new Pair(root, -1));
      
      Stack<Pair> reverseInorder = new Stack<>();
      reverseInorder.push(new Pair(root, -1));
      
      int left = iterativeInorder(inorder);
      int right = iterativeReverseInorder(reverseInorder);
      
      while(left < right){

          if(left + right == target){
            System.out.println(left + " " + right);
            left = iterativeInorder(inorder);
            right = iterativeReverseInorder(reverseInorder);
            
          } else if(left + right < target){
            left = iterativeInorder(inorder);  
          } else {
            right = iterativeReverseInorder(reverseInorder);
          }
      }
  }
  
  public static int iterativeInorder(Stack<Pair> stk) {
    while(!stk.isEmpty()){
        Pair par = stk.peek();
        
        if(par.state == -1){
            // preorder
                
            if(par.node.left != null){
                stk.push(new Pair(par.node.left, -1));
            }
            par.state++;
            
        } else if(par.state == 0){
            // inorder
            int val = par.node.data;
            
            if(par.node.right != null){
                stk.push(new Pair(par.node.right, -1));
            }
            par.state++;
            
            return val;
            
        } else if(par.state == 1){
            // postorder
            stk.pop();
        }
    }
    
    return -1;
  }
  
  public static int iterativeReverseInorder(Stack<Pair> stk) {
    
    while(!stk.isEmpty()){
        Pair par = stk.peek();
        
        if(par.state == -1){
            // reverse preorder
            if(par.node.right != null){
                stk.push(new Pair(par.node.right, -1));
            }
            par.state++;
            
        } else if(par.state == 0){
            // reverse inorder
            int val = par.node.data;
            
            if(par.node.left != null){
                stk.push(new Pair(par.node.left, -1));
            }
            par.state++;
            
            return val;
            
        } else if(par.state == 1){
            // reverse postorder
            stk.pop();
        }
    }
    
    return -1;
  }
