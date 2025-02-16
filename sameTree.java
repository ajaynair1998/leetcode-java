import java.util.*;

public class sameTree {
  public static void main(String[] args) {

  }

  public static Boolean isSameTree(TreeNode p, TreeNode q) {
    return dfsInOrder(p, q);
  }

  public static Boolean dfsInOrder(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if ((p == null && q != null) || (q == null && p != null) || p.val != q.val) {
      return false;
    }

    Boolean childrenIsSame = dfsInOrder(p.left, q.left) && dfsInOrder(p.right, q.right);
    return childrenIsSame;

  }
}