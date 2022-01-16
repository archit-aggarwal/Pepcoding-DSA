class GfG
{
   public static class Node{
        Node[] children = new Node[26];
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
   }
   
   public static int countDistinctSubstring(String s)
   {
       Node root = new Node();
       int count = 1;
       
       for(int i=0; i<s.length(); i++){
           Node curr = root;
           for(int j=i; j<s.length(); j++){
               if(curr.get(s.charAt(j)) == null){
                   curr.set(s.charAt(j));
                   count++;
               }
               curr = curr.get(s.charAt(j));
           }
       }
       return count;
   }
}