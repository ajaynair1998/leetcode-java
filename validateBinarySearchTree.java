import java.util.*;

public class validateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean inorder(TreeNode root, long allowedMinimumValue, long allowedMaxValue) {
    if (root == null) {
      return true;
    }

    if (root.val <= allowedMinimumValue || root.val >= allowedMaxValue) {
      return false;
    }

    return inorder(root.left, allowedMinimumValue, root.val) &&
        inorder(root.right, root.val, allowedMaxValue);
  }
}
