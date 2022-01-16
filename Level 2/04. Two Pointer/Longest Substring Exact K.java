class Solution {
    public int longestkSubstr(String s, int k) {
         int left=0;
        int right=0;
        int length=0;
        
        HashMap<Character,Integer> hm=new HashMap<>();
        while(right<s.length() && left<=right){
            
            //update freq of char at right
            hm.put ( s.charAt(right), hm.getOrDefault(s.charAt(right),0)+1);
            
                  while(hm.size()>k ){
                      hm.put(  s.charAt(left) ,hm.get(s.charAt(left))-1 );
                      
                      if(hm.get(s.charAt(left))==0 ){
                          hm.remove(s.charAt(left));
                      }
                      left++;
                  }
         
            if(hm.size() == k) maxLen
            //invalid then exclude
            right++;
        }
        
        if(length == 0) return -1;
        return length;
        
    }

}