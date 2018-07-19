package linked_list;

import utils.Node;

/**
 * Implement an algorithm to find the nth to the last element of a singly linked list.
 */
public class FindNthFromLast {
  /**
   * Find the nth to the last node.
   *
   * Assume that  given n=0, return the last node; n = 1, return the parent of last node. and if the
   * list contains k node, then n = k - 1 will return the head, any value greater than k-1 will lead
   * to null.
   *
   * @return the node if it existed, null otherwise.
   */
  static Node findNth(Node head, int n) {
    Node fast = head;
    n--;
    while (fast != null && n-- >= 0) {
      fast = fast.next;
    }

    if (fast == null) {
      return null; // out of range
    }

    Node slow = head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow;
  }
}
