import java.util.*;

public class palindromePartitioning {

  public static void main(String[] args) {
    partition("aab");
  }

  public static List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    dfs(s, list, new ArrayList<>(), 0);
    return list;
  }

  public static void dfs(String s, List<List<String>> finalList, List<String> tempList, int start) {
    if (start >= s.length()) {
      finalList.add(new ArrayList<>(tempList));
    } else {

      for (int i = start; i < s.length(); i++) {
        if (isPalindrome(s, start, i)) {
          tempList.add(s.substring(start, i + 1));
          dfs(s, finalList, tempList, i + 1);
          tempList.remove(tempList.size() - 1);
        }

      }
    }

  }

  public static boolean isPalindrome(String s, int low, int high) {
    while (low < high)
      if (s.charAt(low++) != s.charAt(high--))
        return false;
    return true;
  }
}
