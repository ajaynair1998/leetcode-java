import java.lang.reflect.Array;
import java.util.Arrays;

public class coinChangeProblem {
  public static void main(String[] args) {
    int[] coins = { 186, 419, 83, 408 };
    coinChange(coins, 6249);
  }

  public static int coinChange(int[] coins, int amount) {
    // Understood this after watching Back to Back SWE

    int[] minimumCombinationsArray = new int[amount + 1];
    Arrays.fill(minimumCombinationsArray, amount + 1);

    // Using bottom up iterative approch insolving a DP

    for (int total = 0; total <= amount; total++) {
      // The combination to get a total of 0 0 coins
      if (total == 0) {
        minimumCombinationsArray[total] = 0;
        continue;
      }
      for (int coin : coins) {
        int remainder = total - coin;
        if (remainder < 0) {
          continue;
        }

        int maxCoinsNeededForRemainder = minimumCombinationsArray[remainder];
        // This is the most confusing subproblem so if you are confused look at Back to
        // Back SWE
        minimumCombinationsArray[total] = Math.min(maxCoinsNeededForRemainder + 1, minimumCombinationsArray[total]);
      }

    }

    if (minimumCombinationsArray[minimumCombinationsArray.length - 1] < 0
        || minimumCombinationsArray[minimumCombinationsArray.length - 1] == amount + 1) {
      return -1;
    }

    return minimumCombinationsArray[minimumCombinationsArray.length - 1];
  }

}
