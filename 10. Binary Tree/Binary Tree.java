import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
        Stack<Pair> stk = new Stack<>();
        Node root = new Node(arr[0]);
        stk.push(new Pair(root, -1));
        int idx = 0;
        
        while(!stk.isEmpty()){
            
            Pair par = stk.peek();
            
            if(par.state == -1){
                // preorder
                idx++;
                
                if(arr[idx] != null){
                    Node child = new Node(arr[idx]);
                    par.node.left = child;
                    stk.push(new Pair(child, -1));
                }
                par.state++;
                
            } else if(par.state == 0){
                // inorder
                idx++;
                
                if(arr[idx] != null){
                    Node child = new Node(arr[idx]);
                    par.node.right = child;
                    stk.push(new Pair(child, -1));
                }
                par.state++;
                
            } else if(par.state == 1){
                // postorder
                stk.pop();
            }
        }
        
        return root;
  }

  public static void print(Node node){
    
    if(node.left != null) 
        System.out.print(node.left.data);
    else System.out.print(".");
    
    System.out.print(" <- " + node.data + " -> ");
    
    if(node.right != null) 
        System.out.print(node.right.data);
    else System.out.print(".");
    
    System.out.println();
  }
  
  public static void display(Node node) {
      if(node == null) return;
      print(node);
      
      // preorder
      display(node.left);
      // inorder
      display(node.right);
      // postorder
  }

  public static int size(Node node) {
        if(node == null) return 0;
        
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return 1 + leftSize + rightSize;
        // return 1 + size(node.left) + size(node.right);
  }

  public static int sum(Node node) {
        if(node == null) return 0;
        
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        return node.data + leftSum + rightSum;
  }

  public static int max(Node node) {
      if(node == null) return Integer.MIN_VALUE;
      
      int leftMax = max(node.left);
      int rightMax = max(node.right);
      return Math.max(node.data, Math.max(leftMax, rightMax));
  }

//   public static int height(Node node) {
//       if(node == null) return 0;
      
//       // in terms of nodes
//       int leftHeight = height(node.left);
//       int rightHeight = height(node.right);
//       return Math.max(leftHeight, rightHeight) + 1;
//   }

  public static int height(Node node){
      if(node == null) return 0;
      
      int leftHeight = 0, rightHeight = 0;
      
      if(node.left != null){
        leftHeight = 1 + height(node.left);
      }
      
      if(node.right != null){
          rightHeight = 1 + height(node.right);
      }
      
      return Math.max(leftHeight, rightHeight);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    // display(root);
    
    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int ht = height(root);
    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(ht);
  }

}
