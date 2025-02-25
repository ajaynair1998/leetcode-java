import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreamsTests {

  public static String testString = "I am am ajay";

  public static void main(String[] args) {
    getCountOfEachDistinctCharacer(testString);
  }

  public static void getCountOfEachDistinctCharacer(String s) {
    Map<Character, Long> charCount = s.chars().parallel().mapToObj(c -> (char) c)
        .filter(c -> !c.equals(' '))
        .collect(
            Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));

    System.out.println(charCount);

    return;
  }

}
