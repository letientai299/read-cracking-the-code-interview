package linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindCircularNodeTest {

  private Node head;

  @BeforeEach
  public void setup() {
    // prepare a list that loop at node.data = 3
    head = new Node(0);
    Node loop = null;
    Node node = head;
    for (int i = 1; i <= 10; i++) {
      node.next = new Node(i);
      node = node.next;
      if (i == 3) {
        loop = node;
      }
    }
    node.next = loop;
  }

  @Test
  void findCircularNode() {
    Node node = FindCircularNode.findCircularNode(head);
    System.out.println(node.data);
    assertEquals(3, node.data);
  }

  @Test
  void findCircularNodeWithoutBuffer() {
    Node node = FindCircularNode.findCircularNodeWithoutBuffer(head);
    System.out.println(node.data);
    assertEquals(3, node.data);
  }
}
