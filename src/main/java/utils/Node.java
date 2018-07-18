package utils;

public class Node {
  public Node next;
  public int data;

  public Node(int data) {
    this.data = data;
  }

  public void appendToTail(int d) {
    Node tail = this;
    while (tail.next != null) {
      tail = tail.next;
    }

    tail.next = new Node(data);
  }

  public static void printNode(Node head) {
    if (head == null) {
      System.out.println("null");
      return;
    }

    StringBuilder sb = new StringBuilder();
    Node node = head;
    while (node.next != null) {
      sb.append(node.data);
      sb.append(" -> ");
      node = node.next;
    }

    sb.append(node.data);
    System.out.println(sb.toString());
  }
}
