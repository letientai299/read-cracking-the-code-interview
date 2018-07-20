package linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeleteMiddleFromMiddleTest {
  private Node head;

  @BeforeEach
  public void setup() {
    // create a list from 1 to 10
    head = new Node(1);
    Node node = head;
    for (int i = 2; i <= 10; i++) {
      node.next = new Node(i);
      node = node.next;
    }
  }

  @Test
  public void deleteMiddle() {
    Node node = head;
    while (node.data != 4) {
      node = node.next;
    }

    // Try to delete that node
    Node after = DeleteMiddleFromMiddle.deleteMiddle(node);
    for (int i = 5; i < 10; i++) {
      assertEquals(after.data, i);
      after = after.next;
    }
  }

  @Test
  public void deleteMiddle_1ToTheLast() {
    // Try to delete the node just before the last
    Node node = head;
    while (node.data != 9) {
      node = node.next;
    }

    Node after = DeleteMiddleFromMiddle.deleteMiddle(node);
    assertEquals(after.data, 10);
    assertNull(after.next);
  }

  @Test
  public void deleteMiddle_head() {
    // Try to delete the node just before the last
    Node after = DeleteMiddleFromMiddle.deleteMiddle(head);
    for (int i = 2; i < 10; i++) {
      assertEquals(after.data, i);
      after = after.next;
    }
  }
}
