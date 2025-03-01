import java.util.*;
import java.util.stream.Collectors;

public class longestRepeatingCharacterReplacement {
  public static void main(String[] args) {
    String s = "ABBB";
    characterReplacement(s, 2);
  }

  public static int characterReplacement(String s, int k) {
    List<String> listOfStrings = s.chars()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.toList());

    Integer currentMaxFrequency = 0;
    Map<String, Integer> frequency = new HashMap<>();
    Integer maxWindow = 0;
    Integer leftPointer = 0;

    for (Integer rightPointer = 0; rightPointer < listOfStrings.size(); rightPointer++) {
      String currentLetter = listOfStrings.get(rightPointer);
      frequency.compute(currentLetter, (key, value) -> (value == null) ? 1 : value + 1);
      // frequency.merge(currentLetter, 1, Integer::sum);
      currentMaxFrequency = frequency.values().stream().max(Integer::compare).orElse(0);
      // currentMaxFrequency = Collections.max(frequency.values);
      int currentWindowWidth = rightPointer - leftPointer + 1;

      if (currentWindowWidth - currentMaxFrequency > k) {
        String stringAtLeft = listOfStrings.get(leftPointer);
        frequency.compute(stringAtLeft, (key, value) -> value - 1);
        leftPointer = leftPointer + 1;
        currentWindowWidth = currentWindowWidth - 1;
      }
      maxWindow = Math.max(maxWindow, rightPointer - leftPointer + 1);

    }

    return maxWindow;
  }
}
