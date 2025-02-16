
import java.util.*;

public class InsertIntervalProblem {

    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> finalResponseArray = new ArrayList();

        if (intervals.length == 0) {
            finalResponseArray.add(newInterval);
            return finalResponseArray.toArray(new int[finalResponseArray.size()][2]);
        }

        for (Integer currentIndex = 0; currentIndex < intervals.length; currentIndex++) {
            int[] interval = intervals[currentIndex];
            if (newInterval[1] < interval[0]) {
                finalResponseArray.add(newInterval);
                finalResponseArray.
                        addAll(Arrays.asList(Arrays.copyOfRange(intervals, currentIndex, intervals.length)));
                return finalResponseArray.toArray(new int[finalResponseArray.size()][2]);
            } else if (newInterval[0] > interval[1]) {
                finalResponseArray.add(newInterval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        finalResponseArray.add(newInterval);
        return finalResponseArray.toArray(new int[finalResponseArray.size()][2]);

    }
}
