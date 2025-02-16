import java.util.*;

public class MergeIntervals {
  public static void main(String[] args) {
  }

  public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    if (intervals.length < 2) {
      return intervals;
    }

    List<int[]> finalMergedArrays = new ArrayList<>();
    finalMergedArrays.add(intervals[0]);

    // go through each element starting from the second one
    for (Integer currentIndex = 1; currentIndex < intervals.length; currentIndex++) {
      int[] currentConsideredInterval = finalMergedArrays.get(finalMergedArrays.size() - 1);
      Integer startOfCurrentConsideredInterval = currentConsideredInterval[0];
      Integer endOfCurrentConsideredInterval = currentConsideredInterval[1];

      Integer startOfInterval = intervals[currentIndex][0];
      Integer endOfInterval = intervals[currentIndex][1];

      // No more merging because the next interval starts disjointed
      if (startOfInterval > endOfCurrentConsideredInterval) {
        finalMergedArrays.add(intervals[currentIndex]);
      } else if (startOfInterval <= endOfCurrentConsideredInterval) {
        startOfCurrentConsideredInterval = Math.min(startOfInterval, startOfCurrentConsideredInterval);
        endOfCurrentConsideredInterval = Math.max(endOfInterval, endOfCurrentConsideredInterval);
        currentConsideredInterval[0] = startOfCurrentConsideredInterval;
        currentConsideredInterval[1] = endOfCurrentConsideredInterval;
      }

    }

    return finalMergedArrays.toArray(new int[finalMergedArrays.size()][2]);
  }

}
