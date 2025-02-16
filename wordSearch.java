import java.util.*;

public class wordSearch {

  private static Boolean wordExists = false;

  public static void main(String[] args) {
    char[][] board = {
        { 'A', 'B', 'C', 'E' },
        { 'S', 'F', 'C', 'S' },
        { 'A', 'D', 'E', 'E' }
    };
    String word = "ABCB";
    var exists = exist(board, word);
    System.out.println(exists);
  }

  public static boolean exist(char[][] board, String word) {

    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[0].length; column++) {
        dfs(row, column, 0, word, board);
        if (wordExists) {
          return true;
        }
      }
    }
    return false;

  }

  public static void dfs(int i, int j, int currentIndexInSearchWord, String word, char[][] board) {
    if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
      return;
    }
    if ((currentIndexInSearchWord > word.length() - 1) || board[i][j] != word.charAt(currentIndexInSearchWord)) {
      return;
    }

    if (word.charAt(currentIndexInSearchWord) == board[i][j] && currentIndexInSearchWord == word.length() - 1) {
      wordExists = true;
      return;
    }
    Character letter = board[i][j];
    board[i][j] = 0;
    dfs(i + 1, j, currentIndexInSearchWord + 1, word, board);
    dfs(i, j + 1, currentIndexInSearchWord + 1, word, board);
    dfs(i - 1, j, currentIndexInSearchWord + 1, word, board);
    dfs(i, j - 1, currentIndexInSearchWord + 1, word, board);
    board[i][j] = letter;
  }

}
