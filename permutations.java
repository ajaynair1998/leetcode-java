import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class permutations {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    var data = permute(nums);
    System.out.println(data);
    return;
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(nums, new ArrayList<>(), new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList())),
        result);
    return result;
  }

  public static void dfs(int[] nums, List<Integer> currentCandidate, Set<Integer> candidatesLeft,
      List<List<Integer>> result) {
    if (candidatesLeft.size() <= 0) {
      result.add(new ArrayList<>(currentCandidate));
    }
    for (int number : nums) {
      if (candidatesLeft.contains(number)) {
        currentCandidate.add(number);
        candidatesLeft.remove(number);
        dfs(nums, currentCandidate, candidatesLeft, result);
        currentCandidate.remove(currentCandidate.size() - 1);
        candidatesLeft.add(number);
      }
    }
  }

}
