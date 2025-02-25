import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
    int leftPointer = 1;
    int rightPointer = Arrays.stream(piles).max().orElse(1);
    int currentMinimumValueAtATime = rightPointer;

    while (leftPointer <= rightPointer) {
      int valueToTest = (leftPointer + rightPointer) / 2;

      if (currentNumberCanFinishArrayIteration(piles, valueToTest, h)) {
        currentMinimumValueAtATime = Math.min(currentMinimumValueAtATime, valueToTest);
        rightPointer = valueToTest - 1;
      } else {
        leftPointer = valueToTest + 1;
      }
    }

    return currentMinimumValueAtATime;
  }

  public boolean currentNumberCanFinishArrayIteration(int[] array, int valueAtAtime, int maxIterationsPossible) {
    int totalIterations = 0;

    for (int a : array) {
      totalIterations += Math.ceil((double) a / valueAtAtime);
      if (totalIterations > maxIterationsPossible)
       return false;
    }

    return totalIterations <= maxIterationsPossible;
  }
}
