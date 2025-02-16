import java.util.*;

public class subsets {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    List<List<Integer>> finalList = subsets(nums);
    System.out.println(finalList);
    return;
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> finalList = new ArrayList<>();
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
    dfs(currentPermutation, finalList, currentIndexPosition + 1, nums);
  }
}
