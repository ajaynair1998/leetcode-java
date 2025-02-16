import java.util.*;

public class serializeAndDeserializeBinaryTree {
  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "X";
    }

    String serializedLeftSubTree = serialize(root.left);
    String serializedRightSubtree = serialize(root.right);

    return String.join(",", Integer.toString(root.val), serializedLeftSubTree, serializedRightSubtree);

  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));
    return deserializeHelper(queue);

  }

  public static TreeNode deserializeHelper(Queue<String> queue) {
    String value = queue.poll();

    if (value.equals("X")) {
      return null;
    }

    TreeNode leftSubTree = deserializeHelper(queue);
    TreeNode rightSubTree = deserializeHelper(queue);

    TreeNode currentNode = new TreeNode();

    currentNode.val = Integer.valueOf(value);
    currentNode.left = leftSubTree;
    currentNode.right = rightSubTree;

    return currentNode;

  }
}
