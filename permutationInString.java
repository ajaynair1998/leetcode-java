import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class permutationInString {
  public static void main(String[] args) {
    String s1 = "ab";
    String s2 = "eidbaooo";
    checkInclusion(s1, s2);
  }

  public static boolean checkInclusion(String s1, String s2) {
    Map<Character, Long> mapOfS1 = s1.chars().mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Character, Long> mapOfWindow = new HashMap<>();
    int leftPointer = 0;

    for (int rightPointer = 0; rightPointer < s2.length(); rightPointer++) {

      Character characterAtRightPointer = s2.charAt(rightPointer);
      mapOfWindow.put(characterAtRightPointer, mapOfWindow.getOrDefault(characterAtRightPointer, (long) 0) + 1);

      if ((rightPointer - leftPointer + 1) > s1.length()) {
        Character characterAtLeftPointer = s2.charAt(leftPointer);
        mapOfWindow.compute(characterAtLeftPointer, (key, value) -> (value == 1) ? null : value - 1);
        leftPointer++;
      }

      if (mapOfS1.equals(mapOfWindow)) {
        return true;
      }
    }

    return false;
  }

}
