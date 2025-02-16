import java.util.*;

public class binaryTreeLevelOrder {

  public static void main(String[] args) {

  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> nodesInEachLevel = new ArrayList<>();

    queue.add(root);

    while (queue.size() != 0) {
      Integer numberOfNodesInThisLevel = queue.size();
      List<Integer> valuesInThislevel = new ArrayList<>();
      for (int i = 0; i < numberOfNodesInThisLevel; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }

        valuesInThislevel.add(node.val);
      }

      nodesInEachLevel.add(new ArrayList<>(valuesInThislevel));

    }

    return nodesInEachLevel;
  }
}
