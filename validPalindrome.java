import java.util.*;
import java.util.stream.Collectors;

public class validPalindrome {
  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    isPalindrome(s);

  }

  public static boolean isPalindrome(String s) {

    List<Character> arrayCharacters = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().chars().mapToObj(c -> (char) c)
        .collect(Collectors.toList());
    Integer startPointer = 0;
    Integer endPointer = arrayCharacters.size() - 1;

    while (startPointer < endPointer) {
      Character charAtStart = arrayCharacters.get(startPointer);
      Character characterAtEnd = arrayCharacters.get(endPointer);

      if (charAtStart.equals(characterAtEnd)) {
        startPointer++;
        endPointer--;
      } else {
        return false;
      }

    }

    return true;

  }

}
