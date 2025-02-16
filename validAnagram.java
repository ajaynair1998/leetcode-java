import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class validAnagram {
  public static void main(String[] args) {
    solveWithSorting("baba", "abab");
  }

  public static Boolean solveWithSorting(String s, String t) {
    String sortedSString = s.chars().sorted().mapToObj(c -> (char) c).map(String::valueOf)
        .collect(Collectors.joining());
    String sortedTString = t.chars().sorted().mapToObj(c -> (char) c).map(String::valueOf)
        .collect(Collectors.joining());

    if (sortedSString.equals(sortedTString)) {
      return true;
    }

    return false;

  }

  public static Boolean solveBySortingTheStringAndMerging(String s, String t) {
    List<Character> sList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(ArrayList::new));
    sList.sort(ascendingComparator);
    StringBuilder builderForS = new StringBuilder();

    for (char ch : sList) {
      builderForS.append(ch);
    }

    String mergedSString = builderForS.toString();

    List<Character> tList = t.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(ArrayList::new));
    tList.sort(ascendingComparator);
    StringBuilder builderForT = new StringBuilder();

    for (char ch : tList) {
      builderForT.append(ch);
    }

    String mergedTString = builderForT.toString();

    if (mergedSString.equals(mergedTString)) {
      return true;

    }

    return false;
  }

  public static Comparator<Character> ascendingComparator = (ch1, ch2) -> ch1 - ch2;
  public static Comparator<Character> descendingComparator = (ch1, ch2) -> ch2 - ch1;

}
