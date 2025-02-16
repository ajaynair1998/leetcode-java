import java.util.*;

public class combinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> results = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(results, new ArrayList<>(), 0, candidates, target, 0);
    return results;
  }

  public void dfs(List<List<Integer>> results, List<Integer> currentCandidates, Integer currentSum, int[] candidates,
      Integer target, int currentIndex) {
    if (currentSum > target) {
      // do nothing
      return;
    } else if (currentSum == target) {
      results.add(new ArrayList<>(currentCandidates));
    } else if (currentSum < target) {
      for (int start = currentIndex; start < candidates.length; start++) {

        currentCandidates.add(candidates[start]);
        dfs(results, currentCandidates, currentSum + candidates[start], candidates, target, start);
        currentCandidates.remove(currentCandidates.size() - 1);

      }
    }

  }
}
