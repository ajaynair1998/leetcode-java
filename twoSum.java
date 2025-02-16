import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class twoSum {
  public static void main(String[] args) {
    int[] nums = { 3, 2, 4 };
    twoSumWithTwoPointers(nums, 6);
  }

  public static int[] twoSumWithHashMap(int[] nums, int target) {
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {

      Integer complement = target - nums[i];

      if (hashMap.get(complement) != null) {
        return new int[] { hashMap.get(complement), i };
      }

      hashMap.put(nums[i], i);

    }
    return new int[] {};
  }

  public static int[] twoSumWithTwoPointers(int[] nums, int target) {
    // this is not correct just tryin things
    List<Integer> numbersAsList = Arrays.stream(nums).boxed().sorted(comparatorForSortingInAscendingOrder)
        .collect(Collectors.toList());

    Integer startPointer = 0;
    Integer endPointer = numbersAsList.size() - 1;

    while (startPointer < endPointer) {
      Integer startValue = numbersAsList.get(startPointer);
      Integer endValue = numbersAsList.get(endPointer);
      Integer currentTotal = startValue + endValue;

      if (currentTotal.equals(target)) {
        return new int[] { startPointer, endPointer };
      }

      if (currentTotal < target) {
        startPointer++;
      } else {
        endPointer--;
      }

    }

    return new int[] {};
  }

  public static Comparator<Integer> comparatorForSortingInAscendingOrder = (int1, int2) -> int1 - int2;

}
