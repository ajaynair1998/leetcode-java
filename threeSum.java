import java.util.*;
import java.util.stream.Collectors;

public class threeSum {

  public static void main(String[] args) {
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    threeSumFunction(nums);

  }

  public static List<List<Integer>> threeSumFunction(int[] nums) {
    List<Integer> listOfNumbers = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());

    Integer primaryPointer = 0;
    Integer target = 0;

    List<List<Integer>> possibleValues = new ArrayList<>();

    while (primaryPointer < listOfNumbers.size() - 2) {

      Integer leftPointer = primaryPointer + 1;
      Integer rightPointer = listOfNumbers.size() - 1;

      if (primaryPointer > 0 && listOfNumbers.get(primaryPointer).equals(listOfNumbers.get(primaryPointer - 1))) {
        primaryPointer++;
        continue;
      }

      while (leftPointer < rightPointer) {
        Integer total = listOfNumbers.get(primaryPointer) + listOfNumbers.get(leftPointer)
            + listOfNumbers.get(rightPointer);
        if (total.equals(target)) {
          int[] currentCombination = { listOfNumbers.get(primaryPointer), listOfNumbers.get(leftPointer),
              listOfNumbers.get(rightPointer) };
          List<Integer> currentCombinationList = Arrays.stream(currentCombination).boxed().collect(Collectors.toList());
          possibleValues.add(currentCombinationList);

          leftPointer++;
          while (listOfNumbers.get(leftPointer).equals(listOfNumbers.get(leftPointer - 1))
              && leftPointer < rightPointer) {
            leftPointer++;

          }
        } else if (total < target) {
          leftPointer++;
          continue;
        } else {
          rightPointer--;
          continue;

        }

      }
      primaryPointer++;

    }
    return possibleValues;
  }

}
