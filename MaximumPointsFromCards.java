import java.util.*;

public class MaximumPointsFromCards {
  public int maxScore(int[] cardPoints, int k) {
    // Max score sliding window on the left Side
    Integer maxScoreValue = 0;
    for (Integer currentIndex = 0; currentIndex < k; currentIndex++) {
      maxScoreValue = maxScoreValue + cardPoints[currentIndex];
    }

    Integer currentSlidingWindowScore = maxScoreValue;

    // now increment pointer from right while subracting from maxScore
    for (Integer currentIndex = 0; currentIndex < k; currentIndex++) {
      Integer indexValueFromRight = cardPoints.length - 1 - currentIndex;
      Integer indexValueFromLeft = k - 1 - currentIndex;

      Integer valueOnTheRight = cardPoints[indexValueFromRight];
      Integer valueOnTheLeft = cardPoints[indexValueFromLeft];

      currentSlidingWindowScore = currentSlidingWindowScore - valueOnTheLeft + valueOnTheRight;
      maxScoreValue = Math.max(maxScoreValue, currentSlidingWindowScore);

    }

    return maxScoreValue;
  }
}
