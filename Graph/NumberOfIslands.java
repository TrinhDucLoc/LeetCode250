import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {

  public static void main(String[] args) {
    char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
    System.out.println(numIslands(grid));
  }

  public static int numIslands(char[][] grid) {
    int isLands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    Set<String> visited = new HashSet<>();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
          isLands++;
          bfs(grid, r, c, rows, cols, visited);
        }
      }
    }

    return isLands;
  }


  private static void bfs(char[][] grid, int r, int c, int rows, int cols, Set<String> visited) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{r,c});
    visited.add(r + "," + c);
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    while (!q.isEmpty()) {
      int[] point = q.poll();
      int row = point[0], col = point[1];
      for (int[] direction : directions) {
        int nr = row + direction[0];
        int nc = col + direction[1];

        if (nr >= 0 && nr < rows
        && nc >= 0 && nc < cols
        && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc))  {
          q.add(new int[]{nr, nc});
          visited.add(nr + "," + nc);
        }
      }
    }
  }
}
