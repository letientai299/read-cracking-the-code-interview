package tree_graphs;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class TreeBalanceCheckerTest {

  @Test
  public void isBalance_true() throws Exception {
    String serialize = "1,2,,,3,,";
    final TreeNode root = TreeNode.deserialize(serialize);
    assertThat(TreeBalanceChecker.isBalance(root)).isTrue();
  }

  @Test
  public void isBalance_false() throws Exception {
    String serialize = "1,2,3,,,";
    final TreeNode root = TreeNode.deserialize(serialize);
    assertThat(TreeBalanceChecker.isBalance(root)).isFalse();
  }
}