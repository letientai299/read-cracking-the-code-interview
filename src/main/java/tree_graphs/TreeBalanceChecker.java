package tree_graphs;

import lombok.NonNull;
import utils.TreeNode;

public class TreeBalanceChecker {
  static boolean isBalance(@NonNull TreeNode root) {
    return (maxDept(root) - minDepth(root)) <= 1;
  }

  private static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.min(minDepth(root.getLeft()), minDepth(root.getRight()));
  }

  private static int maxDept(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(maxDept(root.getLeft()), maxDept(root.getRight()));
  }
}
