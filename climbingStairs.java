import java.util.*;

public class climbingStairs {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 2;
    }

    int[] arrayOfPossibleValues = new int[n];
    Arrays.fill(arrayOfPossibleValues, 0);

    arrayOfPossibleValues[0] = 1;
    arrayOfPossibleValues[1] = 2;

    for (Integer currentIndex = 2; currentIndex < n; currentIndex++) {
      arrayOfPossibleValues[currentIndex] = arrayOfPossibleValues[currentIndex - 1]
          + arrayOfPossibleValues[currentIndex - 2];
    }

    return arrayOfPossibleValues[arrayOfPossibleValues.length - 1];

  }
}
