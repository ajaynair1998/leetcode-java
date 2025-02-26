import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class binarySearch {
  public static void main(String[] args) {
    doBinarySearch(null, 0);
  }

  public static int doBinarySearch(int[] nums, int target) {
    Integer leftPointer = 0;
    Integer rightPointer = nums.length - 1;

    List<Integer> listOfNumbers = Arrays.stream(nums).boxed().collect(Collectors.toList());

    while (leftPointer <= rightPointer) {
      Integer midPointer = (int) Math.floor((leftPointer + rightPointer) / 2);
      Integer valueAtMidPointer = listOfNumbers.get(midPointer);

      if (target == valueAtMidPointer) {
        return midPointer;

      }

      if (valueAtMidPointer < target) {
        leftPointer = midPointer + 1;
        continue;
      }

      if (valueAtMidPointer > target) {
        rightPointer = midPointer - 1;
      }

    }

    return -1;
  }

}
