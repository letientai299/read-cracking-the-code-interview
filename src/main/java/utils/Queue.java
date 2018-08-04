package utils;

/**
 * Basic queue
 */
public class Queue {
  Node head;
  Node tail;

  void enqueue(Integer item) {
    final Node node = new Node(item);
    if (isEmpty()) {
      head = node;
      tail = node;
      return;
    }
    tail.next = node;
    tail = node;
  }

  Node dequeue() {
    if (isEmpty()) {
      return null;
    }

    Node node = head;
    head = head.next;
    return node;
  }

  boolean isEmpty() {
    return head == null;
  }
}
