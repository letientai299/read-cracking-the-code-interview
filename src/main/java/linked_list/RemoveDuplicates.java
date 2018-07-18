package linked_list;

import java.util.HashSet;
import java.util.Set;
import utils.Node;

public class RemoveDuplicates {
  /**
   * Remove duplicates from the input linked list, with additional buffer is permitted.
   *
   * This run in O(n), due to the used of Set enable O(1) time look up for known data. This use O(n)
   * space.
   */
  static Node removeDuplicates(Node head) {
    if (head == null || head.next == null) return head;

    Set<Integer> knows = new HashSet<>();
    knows.add(head.data);

    Node prev = head;
    Node current = head.next;
    while (current != null) {
      if (knows.contains(current.data)) {
        prev.next = current.next;
      } else {
        knows.add(current.data);
        prev = current;
      }

      current = current.next;
    }

    return head;
  }

  /**
   * Remove duplicates data without using additional space.
   *
   * For each node, check from the head to the previous node to see if the current node contains
   * same data with any of its previous nodes.
   *
   * This run in O(n^2) time and O(1) space.
   */
  static Node removeDuplicatesWithoutBuffer(Node head) {
    if (head == null || head.next == null) return head;

    Node prev = head;
    Node current = head.next;

    while (current != null) {
      Node check = head;
      while (check != current) {
        if (check.data == current.data) {
          prev.next = current.next;
          break;
        }
        check = check.next;
      }

      if (check == current) {
        prev = current;
      }
      current = current.next;
    }

    return head;
  }
}
