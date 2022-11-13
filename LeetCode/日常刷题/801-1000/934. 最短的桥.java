import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private int [][] directions = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1},
    };
    private int[][] grid;
    private boolean[][] visited;
    int m;
    int n;
    // key = x * 100 + y
    List<Integer> set1;
    List<Integer> set2;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];

        int batch = 0;
        set1 = new ArrayList<>();
        set2 = new ArrayList<>();
        List[] sets = new List[] {set1, set2};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, sets[batch]);
                    batch++;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int pos1 : set1) {
            for (int pos2 : set2) {
                res = Math.min(res, getDis(pos1, pos2));
            }
        }
        return res;
    }

    private void dfs(int x, int y, List<Integer> set) {
        visited[x][y] = true;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 1) {
                set.add(encode(x, y));
                continue;
            }
            if (visited[newX][newY]) {
                continue;
            }
            dfs(newX, newY, set);
        }
    }

    private int encode(int x, int y) {
        return x * 100 + y;
    }

    private int[] parse(int key) {
        return new int[] {key / 100, key % 100};
    }

    private int getDis(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]) - 1;
    }
    private int getDis(int pos1, int pos2) {
        return Math.abs(pos1 / 100 - pos2 / 100) + Math.abs(pos1 % 100 - pos2 % 100) - 1;
    }
}