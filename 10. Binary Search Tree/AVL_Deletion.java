class Sol
{
    public static Node llrotation(Node root){
        Node pivot = root.left;
        root.left = pivot.right;
        pivot.right = root;
        
        balanceFactor(root);
        balanceFactor(pivot);
        return pivot;
    }
    public static Node rrrotation(Node root){
        Node pivot = root.right;
        root.right = pivot.left;
        pivot.left = root;
        
        balanceFactor(root);
        balanceFactor(pivot);
        return pivot;
    }
    public static Node lrrotation(Node root){
        root.left = rrrotation(root.left);
        return llrotation(root);
    }
    public static Node rlrotation(Node root){
        root.right = llrotation(root.right);
        return rrrotation(root);
    }
    
    public static int balanceFactor(Node root){
        if(root == null) return 0;
        
        int l = (root.left == null) ? 0 : root.left.height;
        int r = (root.right == null) ? 0 : root.right.height;
        
        root.height = Math.max(l, r) + 1;
        return (l - r);
    }
    
    public static Node succ(Node root) {
        if(root == null || root.left == null) return root;
        return succ(root.left);
    }
    
    public static Node deleteNode(Node root, int key) {
        if(root == null) return null;
        else if(root.data > key) root.left = deleteNode(root.left, key);
        else if(root.data < key) root.right = deleteNode(root.right, key);
        else if(root.left == null && root.right == null) return null; 
        else if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else {
            Node succ = succ(root.right);
            root.data = succ.data;
            root.right = deleteNode(root.right, succ.data);
        }
        
        int balance = balanceFactor(root);
        if(balance > 1){
            if(balanceFactor(root.left) >= 0) return llrotation(root);
            return lrrotation(root);
        }
        
        if(balance < -1){
            if(balanceFactor(root.right) <= 0) return rrrotation(root);
            return rlrotation(root);
        }
        return root;
    }
}
