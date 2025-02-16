import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class groupAnagrams {

  public static void main(String[] args) {
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    groupAnagramsWithHashMap(strs);
  }

  public static List<List<String>> groupAnagramsWithHashMap(String[] strs) {
    Map<String, ArrayList<String>> anagramGroups = new HashMap<>();
    for (String anagram : strs) {
      String sortedUnicodeValues = anagram.chars().sorted().mapToObj(c -> (char) c).map(String::valueOf)
          .collect(Collectors.joining());
      ArrayList<String> groupedStringWithCurrentUnicode = anagramGroups.get(sortedUnicodeValues);
      if (groupedStringWithCurrentUnicode != null) {
        groupedStringWithCurrentUnicode.add(anagram);
      } else {
        ArrayList<String> groupedStrings = new ArrayList<>();
        groupedStrings.add(anagram);
        anagramGroups.put(sortedUnicodeValues, groupedStrings);
      }
      anagramGroups.forEach(null);
    }
    return anagramGroups.values().stream().collect(Collectors.toList());
  }
}
