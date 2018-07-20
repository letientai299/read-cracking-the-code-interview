package linked_list;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Node;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveDuplicatesTest {
  private Node head;

  @BeforeEach
  public void setup() {
    int[] arr = new int[] {1, 2, 3, 4, 1, 2, 1, 3, 4};
    head = new Node(1);
    Node node = head;
    for (int i = 1; i < arr.length; i++) {
      node.next = new Node(arr[i]);
      node = node.next;
    }

    Node.printNode(head);
  }

  @Test
  public void removeDuplicates() {
    Node node = RemoveDuplicates.removeDuplicates(head);
    Node.printNode(node);
    assertNotNull(node);

    boolean noDuplicates = containsNoDuplicates(node);
    assertTrue(noDuplicates);
  }


  @Test
  public void removeDuplicatesWithoutBuffer() {
    Node node = RemoveDuplicates.removeDuplicatesWithoutBuffer(head);
    Node.printNode(node);
    assertNotNull(node);

    boolean noDuplicates = containsNoDuplicates(node);
    assertTrue(noDuplicates);
  }

  private boolean containsNoDuplicates(Node node) {
    Set<Integer> knows = new HashSet<>();
    while (node != null) {
      if (knows.contains(node.data)) {
        return false;
      }
      knows.add(node.data);
      node = node.next;
    }

    return true;
  }
}
