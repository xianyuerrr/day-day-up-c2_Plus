import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    int[][] grid;
    int[][] map;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int row;
    int col;

    public int largestIsland(int[][] grid) {
        int res = 0;
        Map<Integer, Integer> mmap = new HashMap<>();
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        map = new int[row][col];
        int key = 1;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (grid[x][y] == 1) {
                    mmap.put(key, dfs(x, y, key));
                    res = Math.max(res, mmap.get(key));
                    key++;
                }
            }
        }
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (map[x][y] == 0) {
                    int ans = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] d : dir) {
                        int nextX = x + d[0];
                        int nextY = y + d[1];
                        if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                            continue;
                        }
                        if (map[nextX][nextY] != 0 && !set.contains(map[nextX][nextY])) {
                            ans += mmap.get(map[nextX][nextY]);
                            set.add(map[nextX][nextY]);
                        }
                    }
                    res = Math.max(res, ans);
                }
            }
        }
        return res;
    }

    private int dfs(int x, int y, int k) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) {
            return 0;
        }
        int res = 1;
        grid[x][y] = 0;
        map[x][y] = k;
        for (int[] d : dir) {
            res += dfs(x + d[0], y + d[1], k);
        }
        return res;
    }
}