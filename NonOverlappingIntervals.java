import java.util.Arrays;

public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    if (intervals.length < 2) {
      return 0;
    }
    Integer maxDeletesNeeded = 0;
    Integer previousIntervalEnd = intervals[0][1];

    for (Integer currentIndex = 1; currentIndex < intervals.length; currentIndex++) {
      Integer startOfCurrentInterval = intervals[currentIndex][0];
      Integer endOfCurrentInterval = intervals[currentIndex][1];

      if (startOfCurrentInterval < previousIntervalEnd) {
        // Means its overlapping
        maxDeletesNeeded++;
        previousIntervalEnd = Math.min(previousIntervalEnd, endOfCurrentInterval);
      } else {
        previousIntervalEnd = endOfCurrentInterval;
      }
    }

    return maxDeletesNeeded;
  }
}
