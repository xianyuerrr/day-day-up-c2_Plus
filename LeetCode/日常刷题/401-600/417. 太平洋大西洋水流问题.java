import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int [][] Directions = new int [][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int [][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length; n = heights[0].length;
        // 1 <= m, n <= 200
        // 0 <= heights[r][c] <= 105
        List<List<Integer>> res;
        
        // 可以任意流动，并不是只能左上或右下
        // 由于数据规模不大，可以使用 DFS、BFS

        // // 正向思维 BFS
        // res = method1(heights);
        
        // 逆向思维 BFS
        res = method2(heights);

        return res;
    }

    private List<List<Integer>> method2(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        boolean [][] leftUp = new boolean[m][n];
        boolean [][] rightDown = new boolean[m][n];

        Queue<int []> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) bfs(i, 0, queue, leftUp);
        for (int i = 0; i < n; i++) bfs(0, i, queue, leftUp);
        for (int i = 0; i < m; i++) bfs(i, n-1, queue, rightDown);
        for (int i = 0; i < n; i++) bfs(m-1, i, queue, rightDown);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (leftUp[i][j] && rightDown[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int i, int j, Queue<int []> queue, boolean [][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int [] head = queue.poll();
            int x = head[0], y = head[1];
            
            for (int [] dir : Directions) {
                int nextX = x + dir[0], nextY = y + dir[1];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                if (!visited[nextX][nextY] && heights[nextX][nextY] >= heights[x][y]) {
                    queue.offer(new int [] {nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private List<List<Integer>> method1(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean [][] visited = new boolean [m][n];
                boolean leftUp = false; boolean rightDown = false;

                Queue<int []> q = new LinkedList<>();
                q.add(new int[] {i, j});
                
                while (!q.isEmpty() && !(leftUp && rightDown)) {
                    int [] head = q.poll();
                    int x = head[0], y = head[1];
                    visited[x][y] = true;

                    if (x == 0 || y == 0) leftUp = true;
                    if (x == m-1 || y == n-1) rightDown = true;
                    
                    for (int [] dir : Directions) {
                        int delteX = dir[0], delteY = dir[1];
                        if (x + delteX < 0 || x + delteX >= m || y + delteY < 0 || y + delteY >= n) continue;
                        if (visited[x+delteX][y+delteY] || heights[x][y] < heights[x+delteX][y+delteY]) continue;
                        q.add(new int[] {x+delteX, y+delteY});
                    }
                }
                if (leftUp && rightDown) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    
}