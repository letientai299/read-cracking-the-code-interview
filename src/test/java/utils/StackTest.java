package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {
  @Test
  public void testPushAndPop() throws Exception {
    List<Integer> nums = IntStream.range(1, 10).boxed().collect(Collectors.toList());
    Stack stack = new Stack();
    for (Integer num : nums) {
      stack.push(num);
    }

    ArrayList<Integer> reverted = new ArrayList<>();
    while (!stack.isEmpty()) {
      reverted.add(stack.pop().data);
    }

    Collections.reverse(nums);
    assertThat(nums).hasSameElementsAs(reverted);
  }
}