package utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
  private TreeNode left;
  private TreeNode right;
  private int data;

  public TreeNode(int data) {
    this.data = data;
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{").append(data);
    if (left != null) {
      sb.append(", ");
      sb.append("left = ");
      sb.append(left.toString());
    }

    if (right != null) {
      sb.append(", ");
      sb.append("right = ");
      sb.append(right.toString());
    }

    sb.append("}");
    return sb.toString();
  }

  public static String serialize(@NonNull TreeNode treeNode) {
    StringBuilder sb = new StringBuilder();
    sb.append(treeNode.data);
    sb.append(",");
    if (treeNode.left != null) {
      sb.append(serialize(treeNode.left));
    }
    sb.append(",");
    if (treeNode.right != null) {
      sb.append(serialize(treeNode.right));
    }
    return sb.toString();
  }

  public static TreeNode deserialize(String serialize) {
    List<String> ss = Arrays.asList(serialize.split(",", -1));
    final Iterator<String> iter = ss.iterator();
    return deserializeIterator(iter);
  }

  private static TreeNode deserializeIterator(Iterator<String> iter) {
    if (!iter.hasNext()) {
      return null;
    }

    final String value = iter.next();
    if (value.isEmpty()) {
      return null;
    }

    final Integer data = Integer.valueOf(value);
    final TreeNode root = new TreeNode(data);
    root.setLeft(deserializeIterator(iter));
    root.setRight(deserializeIterator(iter));
    return root;
  }
}
