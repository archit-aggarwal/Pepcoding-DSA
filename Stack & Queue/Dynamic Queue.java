import java.io.*;
import java.util.*;

public static class CustomQueue {
    int[] data;
    int front, rear, size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      rear = 0;
      size = 0;
    }

    int size() {
        return size;
    }

    void display() {
        int count = 0, idx = front;
        while(count < size)
        {
            System.out.print(data[idx] + " ");
            count++;
            idx = (idx + 1) % data.length;
        }
        System.out.println();
    }

    void add(int val) {
        if(size == data.length){
            int[] temp = new int[data.length * 2];
            int count = 0, idx = front;
            while(count < size)
            {
                temp[count] = data[idx];
                count++;
                idx = (idx + 1) % data.length;
            }   
            
            front = 0; rear = data.length;            
            data = temp;
        }
        
        data[rear] = val;
        rear = (rear + 1) % data.length;
        size++;
    }

    int remove() {
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        
        
        int val = data[front];
        front = (front + 1) % data.length;
        size--;
        return val;
    }

    int peek() {
        if(size == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        
        return data[front];
    }
  }
