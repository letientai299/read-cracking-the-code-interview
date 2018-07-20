package linked_list;

import java.security.SecureRandom;
import org.junit.jupiter.api.Test;
import utils.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sum2NumbersTest {

  @Test
  public void sum() {
    SecureRandom random = new SecureRandom();
    int x = random.nextInt();
    int y = random.nextInt();

    Node first = makeList(x);
    Node second = makeList(y);
    Node sum = Sum2Numbers.sum(first, second);

    int z = restore(sum);
    assertEquals(z, x + y);
  }

  /**
   * Restore a number form the linked list, which is created by {@link #makeList(int)}.
   */
  private int restore(Node head) {
    int n = 0;
    int power = 1;
    Node node = head;
    while (node != null) {
      n = n + power * node.data;
      power *= 10;
      node = node.next;
    }

    return n;
  }

  /**
   * Create a single linked list that will represent a number.
   */
  private Node makeList(int n) {
    Node dummy = new Node(-1);
    Node current = dummy;
    while (n != 0) {
      current.next = new Node(n % 10);
      current = current.next;
      n /= 10;
    }

    return dummy.next;
  }
}
