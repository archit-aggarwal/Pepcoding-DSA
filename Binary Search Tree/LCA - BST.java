// O(h) time, O(h) recursion space
public static int lca(Node node, int d1, int d2) {
        if(node.data == d1 || node.data == d2){
            return node.data;
            
        } else if(d1 < node.data && d2 < node.data){
            return lca(node.left, d1, d2);
            
        } else if(d1 > node.data && d2 > node.data){
            return lca(node.right, d1, d2);
            
        } else {
            // d1 < node.data < d2 or d2 < node.data < d1
            return node.data;
        }
}
