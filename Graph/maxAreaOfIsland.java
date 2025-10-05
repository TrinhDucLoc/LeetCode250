import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class maxAreaOfIsland {

  public static void main(String[] args) {
    int[][] grid = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
    };
    System.out.println(maxAreaOfIsland(grid)); // Output: 6
  }

  public static int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    Set<String> visited = new HashSet<>();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1 && !visited.contains(r + "," + c)) {
          int maxOneIsland = bfs(grid, r, c, rows, cols, visited);
          maxArea = Math.max(maxArea, maxOneIsland);
        }
      }
    }

    return maxArea;
  }

  private static int bfs(int[][] grid, int r, int c, int rows, int cols, Set<String> visited) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{r, c});
    visited.add(r + "," + c);
    int max = 0;
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    while (!q.isEmpty()) {
      int[] point = q.poll();
      max++;
      int row = point[0], col = point[1];

      for (int[] direction : directions) {
        int nr = row + direction[0];
        int nc = col + direction[1];

        if (nr >=0 && nr < rows && nc >= 0 && nc < cols
        && grid[nr][nc] == 1 && !visited.contains(nr + "," + nc)) {
          q.add(new int[]{nr, nc});
          visited.add(nr + "," + nc);
        }
      }
    }
    return max;
  }
}
