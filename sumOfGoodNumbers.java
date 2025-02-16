import java.util.List;

public class sumOfGoodNumbers {
  public int sumOfGoodNumbers(int[] nums, int k) {

    Integer numberOfGoodElements = 0;
    for (Integer currentIndex = 0; currentIndex < nums.length; currentIndex++) {
      Integer indexOfLeft = currentIndex - k;
      Integer indexOfRight = currentIndex + k;

      Boolean currentIndexIsGood = true;

      if (indexOfLeft >= 0 && nums[currentIndex] <= nums[indexOfLeft]) {
        currentIndexIsGood = false;
      }

      if (indexOfRight < nums.length && nums[currentIndex] <= nums[indexOfRight]) {
        currentIndexIsGood = false;
      }

      if (currentIndexIsGood == true) {
        numberOfGoodElements = numberOfGoodElements + nums[currentIndex];
      }
    }

    return numberOfGoodElements;
  }
}
