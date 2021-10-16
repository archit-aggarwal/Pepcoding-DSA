static int size = 0;
  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;
  static int height = 0;
  
  public static void multisolver(Node root, int level){
      if(root == null) return;
      
      // Preorder
      size++;
      if(root.data < min) min = root.data;
      if(root.data > max) max = root.data;
      if(level > height) height = level;
      
      for(Node child: root.children){
          multisolver(child, level + 1);
      }
  }

  public static class Multisolver{
    int size = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int height = 0;
    
    Multisolver(int size, int min, int max){
        this.size = size;
        this.min = min;
        this.max = max;
    }
  }
  
  public static Multisolver multisolver2(Node root){
      
      Multisolver ans = new Multisolver(1, root.data, root.data);
      
      for(Node child: root.children){
          
          Multisolver temp = multisolver2(child);
          
          ans.size += temp.size;
          ans.max = Math.max(ans.max, temp.max);
          ans.min = Math.min(ans.min, temp.min);
          ans.height = Math.max(ans.height, temp.height + 1);
      }
      
      return ans;
  }
  
  public static void multisolver3(Node root, int level, int[] ans){
      ans[0]++;
      if(root.data < ans[1]) ans[1] = root.data;
      if(root.data > ans[2]) ans[2] = root.data;
      if(level > ans[3]) ans[3] = level;
      
      for(Node child: root.children){
          multisolver3(child, level + 1, ans);
      }
  }
