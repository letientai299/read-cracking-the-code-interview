package utils;

/**
 * Basic stack, follow the implementation provided in the book
 *
 * This Stack based on LinkedList, hence, there's no upper bound limit for stack size, beside the
 * size of  memory.
 */
public class Stack {
  private Node top;

  public void push(int n) {
    Node node = new Node(n);
    node.next = top;
    top = node;
  }

  public Node pop() {
    Node node = top;
    if (top != null) {
      top = top.next;
    }

    return node;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
