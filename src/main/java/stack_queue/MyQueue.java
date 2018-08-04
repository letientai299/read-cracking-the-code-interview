package stack_queue;

import utils.Node;
import utils.Stack;

/**
 * Implement a queue using 2 stacks
 */
public class MyQueue {
  private Stack first = new Stack();
  private Stack second = new Stack();
  private boolean useFirst = true;

  public void enqueue(int data) {
    Stack use = useFirst ? first : second;
    use.push(data);
  }

  public Node dequeue() {
    Stack out = useFirst ? first : second;
    Stack in = useFirst ? second : first;
    useFirst = !useFirst;

    while (!out.isEmpty()) {
      in.push(out.pop().data);
    }

    return in.pop();
  }

  boolean isEmpty() {
    Stack use = useFirst ? first : second;
    return use.isEmpty();
  }
}
