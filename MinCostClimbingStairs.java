import java.util.Arrays;

public class MinCostClimbingStairs {
  public static void main(String[] args) {
    int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
    minCostClimbingStairs(cost);

  }

  public static int minCostClimbingStairs(int[] cost) {
    int[] minValuesArray = new int[cost.length];
    minValuesArray[0] = cost[0];
    minValuesArray[1] = cost[1];
    for (Integer currentIndex = 2; currentIndex < cost.length; currentIndex++) {
      minValuesArray[currentIndex] = Math.min(minValuesArray[currentIndex - 1] + cost[currentIndex],
          minValuesArray[currentIndex - 2] + cost[currentIndex]);

    }
    return Math.min(minValuesArray[cost.length - 1], minValuesArray[cost.length - 2]);

  }
}
