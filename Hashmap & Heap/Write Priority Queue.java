import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    public ArrayList<Integer> data;
    private int size;
    
    public PriorityQueue() {
      data = new ArrayList<>();
      size = 0;
    }
    
    // O(n) for inserting n elements -> per element O(1)
    public PriorityQueue(int[] arr){
        data = new ArrayList<>();
        
        for(int val: arr){
            data.add(val);
            size++;
        }
        
        int lastIdx = size() - 1;
        int lastIdxPar = (lastIdx - 1) /2;
        for(int i=lastIdxPar; i>=0; i--){
            downheapify(i);
        }
    }

    public void add(int val) {
        // O(log n)
        
        data.add(val);
        size++;
        upheapify(size() - 1);
    }
    
    public boolean isSmaller(int i1, int i2){
        if(data.get(i1) < data.get(i2)) return true;
        return false;
    }
    
    public void swap(int i1, int i2){
        int temp = data.get(i1);
        data.set(i1, data.get(i2));
        data.set(i2, temp);
    }
    
    // O(log N) where N = number of nodes in CBT, & logN is height of tree
    public void upheapify(int idx){
        int parIdx = (idx - 1) / 2;
        
        if(isSmaller(idx, parIdx)){
            swap(idx, parIdx);
            upheapify(parIdx);
        }
    }
    
    
    public int remove() {
        // O(log n)
        if(size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        
        int val = peek();
        swap(0, size() - 1);
        // data.remove(size() - 1);
        size--;
        
        downheapify(0);
        return val;
    }
    
    public void downheapify(int idx){
        int min = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        
        if(left < size && isSmaller(left, min)){
            min = left;
        }
        
        if(right < size && isSmaller(right, min)){
            min = right;
        }
        
        if(min != idx){
            swap(idx, min);
            downheapify(min);
        }
    }

    public int peek() {
        // O(1)
        if(size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        
        return data.get(0);
    }

    public int size() {
        // O(1)
        return size;
    }
    
    // public ArrayList<Integer> heapSort(){
    //     ArrayList<Integer> sorted = new ArrayList<>();
        
    //     // nlogn        
    //     while(size() > 0){
    //         int val = remove();
    //         sorted.add(val);
    //     }
        
    //     return sorted;
    // }
    
    // In Place Heap Sort -> O(1) Extra Space
    public ArrayList<Integer> heapSort(){
        while(size() > 0){
            remove();
        }
        
        return data;
    }
  }

  public static void main(String[] args) throws Exception {
    int[] arr = {20, 50, 30, 10, 40, 60};
    PriorityQueue qu = new PriorityQueue(arr);
    
    // qu.add(20);
    // qu.add(50);
    // qu.add(30);
    // qu.add(10);
    // qu.add(40);
    // qu.add(60);
    
    ArrayList<Integer> res = qu.heapSort();
    System.out.println(res);
  }
}
