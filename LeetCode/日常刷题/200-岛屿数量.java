class Solution {
    int [][] directions = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1},
    };
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (!(0 <= x && x < m) || !(0 <= y && y < n) || grid[x][y] == '0') return;
        grid[x][y] = '0';
        int delteX, delteY;
        for (int i=0; i < directions.length; i++) {
            delteX = directions[i][0];
            delteY = directions[i][1];
            dfs(grid, x+delteX, y+delteY);
        }
    }
} 