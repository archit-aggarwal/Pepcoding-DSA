/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right); 
    }

    public static class Pair{
        char state;
        TreeNode node;
        Pair(TreeNode node){
            this.state = 'l';
            this.node = node;
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null,") == true) return null; 
            
        Stack<Pair> stk = new Stack<>();
        String[] tokens = data.split(",");   
        TreeNode root = null;
    
        for(String token: tokens){
            if(token.equals("null") == true){
                if(stk.peek().state == 'l')
                    stk.peek().state = 'r';
                else stk.pop();
                    
            } else {
                TreeNode child = new TreeNode(Integer.parseInt(token));
                if(stk.empty()){
                    root = child;
                } else {
                    if(stk.peek().state == 'l'){
                        stk.peek().node.left = child;
                        stk.peek().state = 'r';
                    } else {
                        stk.peek().node.right = child;
                        stk.pop();
                    }
                }
                stk.push(new Pair(child));
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));