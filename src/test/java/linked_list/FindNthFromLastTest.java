package linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FindNthFromLastTest {
  private Node head;

  @BeforeEach
  public void setup() {
    head = new Node(1);
    Node node = head;
    for (int i = 2; i <= 10; i++) {
      node.next = new Node(i);
      node = node.next;
    }
    Node.printNode(head);
  }

  @Test
  public void findNth_last() {
    int k = 0;
    Node n = FindNthFromLast.findNth(head, k);
    System.out.println(n.data);
    assertEquals(10 - k, n.data);
  }

  @Test
  public void findNth_null() {
    Node n = FindNthFromLast.findNth(head, 10);
    assertNull(n);
  }
}
