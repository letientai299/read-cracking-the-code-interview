package stack_queue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import utils.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class SortStackTest {
  @Test
  public void testSortStack() throws Exception {
    final List<Integer> data = IntStream.range(0, 100).boxed().collect(Collectors.toList());
    Collections.shuffle(data);
    final Stack stack = new Stack();
    for (Integer datum : data) {
      stack.push(datum);
    }

    System.out.println("Before");
    System.out.println(stack);
    SortStack.sort(stack);
    System.out.println("After");
    System.out.println(stack);

    int prev = stack.pop().data;
    while (!stack.isEmpty()) {
      final int current = stack.pop().data;
      assertThat(current).isGreaterThanOrEqualTo(prev);
      prev = current;
    }
  }
}