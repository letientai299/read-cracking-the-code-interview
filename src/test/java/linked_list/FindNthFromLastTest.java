package linked_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Node;

public class FindNthFromLastTest {
  private Node head;

  @Before
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
    Assert.assertEquals(10 - k, n.data);
  }

  @Test
  public void findNth_null() {
    Node n = FindNthFromLast.findNth(head, 10);
    Assert.assertNull(n);
  }
}
