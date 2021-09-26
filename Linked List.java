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

  // Add Node in last
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

  // Add Node in front
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

  // Traverse Linked List
  public void display() {
    Node temp = head;

    while (temp.next != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }

    System.out.println();
  }
}
