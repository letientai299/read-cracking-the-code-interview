package linked_list;

import utils.Node;

/**
 * 2.3 Delete a node in the middle of a single linked list, given onloy access to that node.
 */
public class DeleteMiddleFromMiddle {

  static Node deleteMiddle(Node toBeDeleted) {
    // we can't do anything if the input node is non existed or it is the last node of the list.
    if (toBeDeleted == null || toBeDeleted.next == null) {
      return null;
    }

    Node parent = toBeDeleted;
    Node current = toBeDeleted.next;
    // continue until we reach the last node
    while (current.next != null) {
      parent.data = current.data;
      parent = current;
      current = current.next;
    }

    parent.data = current.data;
    parent.next = null; // remove the last node, which is now obsolete

    // Return access to the next noe (actually it's the same reference to the input with new data)
    // This algorithm actually can work which evey node, except the last
    return toBeDeleted;
  }
}
