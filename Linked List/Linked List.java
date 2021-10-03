import java.lang.*;
import java.io.*;
import java.util.*;

public static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public static class LinkedList {
    Node head;
    Node tail;
    int size;

    // Add Node in last -> O(1)
    void addLast(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
    }

    // Add Node in Front -> O(1)
    public void addFirst(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add At Given Index -> O(N) Worst Case
    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
            return;
        }

        Node newNode = new Node();
        newNode.data = val;

        if (idx == 0) {
            // addfirst
            newNode.next = head;
            head = newNode;
        }

        else if (idx == size) {
            // addlast
            tail.next = newNode;
            tail = newNode;
        }

        else {
            // get element at idx - 1
            Node prev = getNodeAt(idx - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    // Traverse Linked List -> O(N)
    public void display() {
        Node temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Get First Element -> O(1)
    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    // Get Last Element -> O(1) { Provided Tail Pointer }
    public int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }

    // Get Element at given index -> O(N) Worst Case
    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }

        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        }

        if (idx == 0) {
            // getfirst
            return getFirst();
        }
        if (idx == size - 1) {
            // getlast
            return getLast();
        }

        Node temp = head;
        for (int jump = 0; jump < idx; jump++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Get Node at given Index -> O(N)
    public Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Remove First Element -> O(1)
    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        head = head.next;
        size--;
    }

    // Remove Last Element -> O(N) {Singly Linked List}
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        Node secondLast = head;
        // second last node
        while (secondLast.next != tail) {
            secondLast = secondLast.next;
        }

        size--;
        tail = secondLast;
        tail.next = null;
    }

    // Remove Element at Given Index -> O(N) Worst Case
    public void removeAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            // removeFirst
            removeFirst();
        } else if (idx == size - 1) {
            // removeLast
            removeLast();
        } else {
            Node prev = getNodeAt(idx - 1);
            prev.next = prev.next.next;
            size--;
        }
    }
    
    // Display Linked List in Reverse using Recursion:
    // O(N) Time, O(N) Recursion Call Stack Space
    public void displayReverse(Node curr){
      // base case
      if(curr == null) return;
      
      // faith
      displayReverse(curr.next);
      
      // meeting expectation
      System.out.print(curr.data + " ");
    }
}
