package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueTest {
  @Test
  public void testQueue() throws Exception {
    List<Integer> nums = IntStream.range(1, 10).boxed().collect(Collectors.toList());
    Queue q = new Queue();
    for (Integer num : nums) {
      q.enqueue(num);
    }

    List<Integer> values = new ArrayList<>();
    while (!q.isEmpty()) {
      values.add(q.dequeue().data);
    }

    assertThat(nums).hasSameElementsAs(values);
  }
}