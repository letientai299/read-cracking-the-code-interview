package linked_list;

import utils.Node;

public class Sum2Numbers {
  /**
   * 2.4 Sum 2 numbers, which each number is represented by a linked list, where each node contains
   * a singe digit. The digits are stored in reverse orders, such that the 1's digit it as the head
   * of the list.
   */
  static Node sum(Node a, Node b) {
    if (a == null) {
      return b;
    }

    if (b == null) {
      return a;
    }

    Node dummy = new Node(0);
    Node node = dummy;
    int remain = 0;
    while (a != null || b != null) {
      int digit1 = (a != null) ? a.data : 0;
      int digit2 = (b != null) ? b.data : 0;
      int value = digit1 + digit2 + remain;
      remain = value / 10;
      Node newNode = new Node(value % 10);
      node.next = newNode;
      node = newNode;

      if (a != null) {
        a = a.next;
      }

      if (b != null) {
        b = b.next;
      }
    }

    if (remain != 0) {
      node.next = new Node(remain);
    }

    return dummy.next;
  }
}
