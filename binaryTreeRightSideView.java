import java.util.*;

public class binaryTreeRightSideView {

  public static List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Deque<TreeNode> queue = new LinkedList<>();
    List<Integer> lastNodeInEachLevel = new ArrayList<>();

    queue.add(root);

    while (queue.size() != 0) {
      Integer numberOfNodesInThisLevel = queue.size();
      List<Integer> valuesInThislevel = new ArrayList<>();

      for (int i = 0; i < numberOfNodesInThisLevel; i++) {
        TreeNode node = queue.pollFirst();
        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }

        valuesInThislevel.add(node.val);

        if (i == numberOfNodesInThisLevel - 1) {
          lastNodeInEachLevel.add(node.val);
        }

      }

    }

    return lastNodeInEachLevel;
  }
}
