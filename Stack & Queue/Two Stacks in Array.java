public static class TwoStack {
    int[] data;
    int top1, top2, size1, size2;
    

    public TwoStack(int cap) {
      data = new int[cap];
      top1 = -1;
      top2 = cap;
      size1 = size2 = 0;
    }

    int size1() {
        return size1;
    }

    int size2() {
        return size2;
    }

    void push1(int val) {
        if(size1 + size2 == data.length){
            System.out.println("Stack overflow");
            return;
        }
        
        top1++;
        size1++;
        data[top1] = val;
    }

    void push2(int val) {
        if(size1 + size2 == data.length){
            System.out.println("Stack overflow");
            return;
        }
        
        top2--;
        size2++;
        data[top2] = val;        
    }

    int pop1() {
        if(top1 == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        
        int val = data[top1];
        top1--;
        size1--;
        return val;
    }

    int pop2() {
        if(top2 == data.length) {
            System.out.println("Stack underflow");
            return -1;
        }
        
        int val = data[top2];
        top2++;
        size2--;
        return val;        
    }

    int top1() {
        if(top1 == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        
        return data[top1];
    }

    int top2() {
        if(top2 == data.length) {
            System.out.println("Stack underflow");
            return -1;
        }
        
        return data[top2];
    }
  }
