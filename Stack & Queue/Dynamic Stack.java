public static class CustomStack {
    int[] data;
    int tos;
    
    public CustomStack(){
        data = new int[16];
        tos = -1;
    }
    
    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      return tos + 1;
    }

    void display() {
      for (int i = tos; i >= 0; i--) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
    }

    // change the code of this function according to question
    void push(int val) {
        if (tos == data.length - 1) {
          int[] temp = new int[data.length * 2];
          for(int i=0; i<data.length; i++){
              temp[i] = data[i];
          }
          data = temp;
        }
        
        tos++;
        data[tos] = val;
    }

    int pop() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = data[tos];
        tos--;
        return val;
      }
    }

    int top() {
      if (tos == -1) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        return data[tos];
      }
    }
  }
