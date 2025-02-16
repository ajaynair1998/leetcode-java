import java.util.*;

public class lowestCommonAncestorProblem {

  public static void main(String[] args) {

  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root.val == p.val || root.val == q.val) {
      return root;
    }

    TreeNode nodeInLeftSubtree = lowestCommonAncestor(root.left, p, q);
    TreeNode nodeInRightSubtree = lowestCommonAncestor(root.right, p, q);

    if (nodeInLeftSubtree != null && nodeInRightSubtree != null) {
      return root;
    }

    if (nodeInLeftSubtree == null) {
      return nodeInRightSubtree;
    }

    if (nodeInRightSubtree == null) {
      return nodeInLeftSubtree;
    }

    return root;

  }

  public static TreeNode lowestCommonAncestorWithBSTProperty(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (p.val < root.val && q.val < root.val) {
        root = root.left;
      } else if (p.val > root.val && q.val > root.val) {
        root = root.right;
      } else {
        return root;
      }
    }

    return root;

  }

}
