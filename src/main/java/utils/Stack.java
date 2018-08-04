package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Basic stack, follow the implementation provided in the book
 *
 * This Stack based on LinkedList, hence, there's no upper bound limit for stack size, beside the
 * size of  memory.
 *
 * This's NOT thread safe.
 */
public class Stack {
  private Node top;
  private int size = 0;

  public void push(int n) {
    size++;
    Node node = new Node(n);
    node.next = top;
    top = node;
  }

  public Node pop() {
    Node node = top;
    if (top != null) {
      size--;
      top = top.next;
    }

    return node;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public int size() {
    return this.size;
  }

  @Override public String toString() {
    if (isEmpty()) {
      return "[ <empty>";
    }

    List<Integer> data = new ArrayList<>();
    Node node = top;
    while (node != null) {
      data.add(node.data);
      node = node.next;
    }

    Collections.reverse(data);
    final StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (Integer datum : data) {
      sb.append(datum).append(" ");
    }
    return sb.toString().trim();
  }
}
