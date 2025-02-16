public class kthSmallestElementInBst {
  public static int kthSmallest(TreeNode root, int k) {

    BasicClassWrapper basicWrapper = new BasicClassWrapper();
    return inorder(root, k, basicWrapper);
  }

  public static Integer inorder(TreeNode root, Integer value, BasicClassWrapper basicWrapper) {
    if (root == null) {
      return null;
    }

    Integer left = inorder(root.left, value, basicWrapper);
    if (left != null) {
      return left;
    }

    basicWrapper.incrementCount();

    if (basicWrapper.getCount() == value) {
      return root.val;
    }

    return inorder(root.right, value, basicWrapper);

  }
}
