class Solution
{
    public Node llrotation(Node root){
        Node pivot = root.left;
        root.left = pivot.right;
        pivot.right = root;
        
        balanceFactor(root);
        balanceFactor(pivot);
        return pivot;
    }
    public Node rrrotation(Node root){
        Node pivot = root.right;
        root.right = pivot.left;
        pivot.left = root;
        
        balanceFactor(root);
        balanceFactor(pivot);
        return pivot;
    }
    public Node lrrotation(Node root){
        root.left = rrrotation(root.left);
        return llrotation(root);
    }
    public Node rlrotation(Node root){
        root.right = llrotation(root.right);
        return rrrotation(root);
    }
    
    public int balanceFactor(Node root){
        if(root == null) return 0;
        
        int l = (root.left == null) ? 0 : root.left.height;
        int r = (root.right == null) ? 0 : root.right.height;
        
        root.height = Math.max(l, r) + 1;
        return (l - r);
    }
    
    public Node insertToAVL(Node root, int data)
    {
        if(root == null) return new Node(data);
        
        if(data < root.data) root.left = insertToAVL(root.left, data);
        else if(data > root.data) root.right = insertToAVL(root.right, data);
        else return root;
        
        int balance = balanceFactor(root);
        
        if(balance > 1){
            if(data < root.left.data) return llrotation(root);
            return lrrotation(root);
        }
        
        if(balance < -1){
            if(data > root.right.data) return rrrotation(root);
            return rlrotation(root);
        }
        
        return root;
    }
}
