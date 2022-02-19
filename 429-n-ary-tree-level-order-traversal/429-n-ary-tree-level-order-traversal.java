/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        Node marker = new Node(-1);
        q.add(marker);
        
        List<Integer> level = new ArrayList<>();
        while(q.size() > 1){
            Node curr = q.remove();
            if(curr == marker){
                res.add(level);
                level = new ArrayList<>();
                q.add(marker);
            }
            else {
                level.add(curr.val);
                for(Node child: curr.children){
                    q.add(child);
                }
            }
        }
        if(level.size() > 0) res.add(level);
        return res;
    }
}