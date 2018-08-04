package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeTest {
  private TreeNode treeNode;

  @Test
  public void testSerialize_1() throws Exception {
    treeNode = new TreeNode(1);
    final String serialized = TreeNode.serialize(treeNode);
    assertThat(serialized).isEqualTo("1,,");
  }

  @Test
  public void testSerialize_2() throws Exception {
    treeNode = new TreeNode(1);
    treeNode.setLeft(new TreeNode(2));
    treeNode.setRight(new TreeNode(3));
    final String serialized = TreeNode.serialize(treeNode);
    assertThat(serialized).isEqualTo("1,2,,,3,,");
  }

  @Test
  public void testDeserialize() throws Exception {
    final String serialized = "1,2,3,,,4,,,5,6,,,";
    final TreeNode deserialize = TreeNode.deserialize(serialized);
    assertThat(TreeNode.serialize(deserialize)).isEqualTo(serialized);
  }
}