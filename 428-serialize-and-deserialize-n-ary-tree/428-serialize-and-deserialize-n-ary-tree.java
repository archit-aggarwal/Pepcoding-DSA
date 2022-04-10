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

class Codec {
    public String serialize(Node root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[" + root.val + ",null,");
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int count = q.size();
            while(count-- > 0){
                Node curr = q.remove();
                for(Node child: curr.children){
                    q.add(child);
                    res.append(child.val + ",");
                }
                res.append("null,");
            }
        }
        res.setCharAt(res.length() - 1, ']');
        return res.toString();
    }
	
    public Node deserialize(String input) {
        if(input.equals("[]") == true) 
            return null;
        
        input = input.substring(1, input.length() - 1);
        String[] nodes = input.split(",");
        
        Node root = new Node(Integer.parseInt(nodes[0]));
        root.children = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int index = 2;
        while (!q.isEmpty()) {
            Node par = q.remove();
            while(index < nodes.length) {
                String str = nodes[index++];
                if(str.equals("null") == true) break;
                
                Node child = new Node(Integer.parseInt(str));
                child.children = new ArrayList<>();
                par.children.add(child);
                q.add(child);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));