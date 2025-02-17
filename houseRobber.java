import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HouseRobber {
  public static int rob1(int[] nums) {

    int avoidingAdjacentHouseMax = 0;
    int adjacentHouseMax = 0;

    for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
      int maxRob = Math.max(avoidingAdjacentHouseMax + nums[currentIndex], adjacentHouseMax);
      avoidingAdjacentHouseMax = adjacentHouseMax;
      adjacentHouseMax = maxRob;
    }

    return adjacentHouseMax;
  }

  public static int robHelper(int[] nums) {

    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];

    int avoidingAdjacentHouseMax = 0;
    int adjacentHouseMax = 0;

    for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
      int maxRob = Math.max(avoidingAdjacentHouseMax + nums[currentIndex], adjacentHouseMax);
      avoidingAdjacentHouseMax = adjacentHouseMax;
      adjacentHouseMax = maxRob;
    }

    return adjacentHouseMax;
  }

  public static int rob2(int[] nums) {
    if (nums.length == 1)
      return nums[0];

    int[] arrayWithoutFirstHouse = Arrays.copyOfRange(nums, 1, nums.length);
    int[] arrayWithoutLastHouse = Arrays.copyOfRange(nums, 0, nums.length - 1);

    return Math.max(robHelper(arrayWithoutFirstHouse), robHelper(arrayWithoutLastHouse));
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(rob2(nums)); // Expected output: 3
  }
}
