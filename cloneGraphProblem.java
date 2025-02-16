import java.util.*;

public class cloneGraphProblem {
  public static Map<Integer, Node> hashMap;

  public static Node cloneGraph(Node node) {
    hashMap = new HashMap<Integer, Node>();
    return dfs(node);
  }

  public static Node dfs(Node node) {
    if (node == null) {
      return null;
    }

    Node nodeAlreadyCloned = hashMap.get(node.val);

    if (nodeAlreadyCloned != null) {
      return nodeAlreadyCloned;
    }

    Node copy = new Node(node.val);
    hashMap.put(copy.val, copy);

    for (Node currentNode : node.neighbors) {
      copy.neighbors.add(dfs(currentNode));

    }

    return copy;
  }
}
