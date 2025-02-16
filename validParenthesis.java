import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class validParenthesis {
  public static void main(String[] args) {

    String s = "()[]{}";
    isValid(s);

  }

  public static Boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    ArrayList<Character> arrayOfCharacters = s.chars().mapToObj(c -> (char) c)
        .collect(Collectors.toCollection(ArrayList::new));

    for (Character ch : arrayOfCharacters) {
      if (stack.isEmpty()) {
        stack.add(ch);
        continue;
      }

      Character lastCharacter = stack.peek();
      Optional<Character> reverse = reverseOfCharacter(lastCharacter);

      if (reverse.isPresent() && ch.equals(reverse.get())) {

        stack.pop();
      } else {
        stack.add(ch);
      }
    }

    if (stack.empty()) {
      return true;
    }
    return false;

  }

  public static Optional<Character> reverseOfCharacter(Character ch) {
    switch (ch) {
      case '{':
        return Optional.of('}');

      case '(':
        return Optional.of(')');

      case '[':
        return Optional.of(']');

      default:
        return Optional.empty(); // No matching reverse character
    }

  }

}
