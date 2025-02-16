import java.util.*;
import java.util.stream.Collectors;

public class numberOfIslands {

  private static int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
  private static Map<Integer, Set<Integer>> visitedDictionary = new HashMap<>();

  public static void main(String[] args) {
    char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' } };

    numIslands(grid);
  }

  public static int numIslands(char[][] grid) {
    Integer totalIslands = 0;
    visitedDictionary = new HashMap<>();

    for (Integer row = 0; row < grid.length; row++) {
      for (Integer column = 0; column < grid[0].length; column++) {
        if (visitedNode(row, column) == false && grid[row][column] == '1') {
          System.out.println(visitedDictionary);
          bfs(grid, row, column);
          totalIslands++;
        }
      }
    }

    return totalIslands;
  }

  public static void bfs(char[][] grid, int row, int column) {
    Deque<List<Integer>> stack = new LinkedList<>();
    int[] startPosition = { row, column };
    stack.add(Arrays.stream(startPosition).boxed().collect(Collectors.toList()));

    while (stack.peek() != null) {
      for (int i = 0; i < stack.size(); i++) {
        List<Integer> lastPosition = stack.pollFirst();
        Integer currentRow = lastPosition.get(0);
        Integer currentColumn = lastPosition.get(1);

        if (currentRow < 0 || currentRow >= grid.length || currentColumn < 0 || currentColumn >= grid[0].length
            || visitedNode(currentRow, currentColumn) || grid[currentRow][currentColumn] == '0') {
          continue;
        }

        setVisitedNode(currentRow, currentColumn);

        for (int[] direction : directions) {
          int[] newPosition = { currentRow + direction[0], currentColumn + direction[1] };
          stack.add(Arrays.stream(newPosition).boxed().collect(Collectors.toList()));
        }

      }
    }

  }

  public static boolean visitedNode(int row, int column) {
    return visitedDictionary.getOrDefault(row, new HashSet<>()).contains(column);
  }

  public static void setVisitedNode(int row, int column) {
    visitedDictionary.computeIfAbsent(row, k -> new HashSet<>()).add(column);
  }
}
