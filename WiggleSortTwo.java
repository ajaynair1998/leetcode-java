import java.util.Arrays;

public class WiggleSortTwo {
  // From LintCode question No: 508
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);

    int pointerForSmallerNumber = (nums.length - 1) / 2;
    int pointerForLargerNumber = nums.length - 1;
    int[] finalArray = new int[nums.length];

    for (int pointer = 0; pointer < nums.length; pointer++) {
      if (pointer % 2 == 0) {
        finalArray[pointer] = nums[pointerForSmallerNumber];
        pointerForSmallerNumber--;
        continue;
      }

      if (pointer % 2 == 1) {
        finalArray[pointer] = nums[pointerForLargerNumber];
        pointerForLargerNumber--;
        continue;
      }

    }
    System.arraycopy(finalArray, 0, nums, 0, finalArray.length);

  }

}
