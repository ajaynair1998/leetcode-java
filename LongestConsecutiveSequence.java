
import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maximumSequenceLength = 0;

        Set<Integer> setOfIntegers = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (Integer value : setOfIntegers) {
            Boolean previousValueExists = setOfIntegers.contains(value - 1);
            if (previousValueExists) {
                continue;
            }

            Integer sequenceStartValue = value;
            Integer currentSequencelength = 1;
            while (setOfIntegers.contains(sequenceStartValue + 1)) {
                sequenceStartValue = sequenceStartValue + 1;
                currentSequencelength = currentSequencelength + 1;
            }

            maximumSequenceLength = Math.max(maximumSequenceLength, currentSequencelength);

        }

        return maximumSequenceLength;
    }
}