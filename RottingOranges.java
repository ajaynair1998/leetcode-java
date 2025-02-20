import java.util.*;

public class RottingOranges {

  private static final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public int orangesRotting(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    Deque<int[]> queue = new LinkedList<>();
    int freshOranges = 0;

    // Find all currently rotting oranges and count fresh oranges
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 2) {
          queue.add(new int[] { row, col });
        } else if (grid[row][col] == 1) {
          freshOranges++;
        }
      }
    }

    // If there are no fresh oranges, return 0
    if (freshOranges == 0)
      return 0;

    int minutes = 0;

    // BFS processing
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean newRottenFound = false;
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        int row = current[0];
        int col = current[1];

        for (int[] neighbor : directions) {
          int newRow = row + neighbor[0];
          int newCol = col + neighbor[1];

          if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
              && grid[newRow][newCol] == 1) {
            grid[newRow][newCol] = 2; // Mark as rotten
            queue.add(new int[] { newRow, newCol });
            freshOranges--; // Reduce fresh orange count
            newRottenFound = true;
          }
        }
      }
      if (newRottenFound)
        minutes++;
    }

    // If fresh oranges remain, return -1
    return freshOranges == 0 ? minutes : -1;
  }

}
