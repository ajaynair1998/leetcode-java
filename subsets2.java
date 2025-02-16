import java.util.*;

public class subsets2 {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 2 };
    var data = subsetsWithDup(nums);
    return;
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> finalList = new ArrayList<>();
    Arrays.sort(nums);
    List<Integer> subset = new ArrayList<>();
    dfs(subset, finalList, 0, nums);
    return finalList;

  }

  public static void dfs(List<Integer> currentPermutation, List<List<Integer>> finalList,
      Integer currentIndexPosition, int[] nums) {
    if (currentIndexPosition >= nums.length) {
      finalList.add(new ArrayList<>(currentPermutation));
      return;
    }

    currentPermutation.add(nums[currentIndexPosition]);
    dfs(currentPermutation, finalList, currentIndexPosition + 1, nums);

    currentPermutation.remove(currentPermutation.size() - 1);
    Integer totalSameNumbers = 0;
    while (totalSameNumbers + currentIndexPosition + 1 < nums.length
        && nums[totalSameNumbers + currentIndexPosition] == nums[totalSameNumbers + currentIndexPosition + 1]) {
      totalSameNumbers++;
    }
    dfs(currentPermutation, finalList, totalSameNumbers + currentIndexPosition + 1, nums);
  }
}
