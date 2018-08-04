package stack_queue;

import utils.Node;
import utils.Stack;

public class SortStack {
  /**
   * Sort stack using Stack with its 4 methods;
   *
   * - peek - push - pop - isEmpty
   */
  static void sort(Stack input) {
    if (input == null || input.isEmpty()) {
      return;
    }

    final Stack dataHolder = new Stack();
    while (!input.isEmpty()) {
      final Node node = input.pop();
      while (!dataHolder.isEmpty() && dataHolder.peek() > node.data) {
        input.push(dataHolder.pop().data);
      }

      dataHolder.push(node.data);
    }

    while (!dataHolder.isEmpty()) {
      input.push(dataHolder.pop().data);
    }
  }
}
