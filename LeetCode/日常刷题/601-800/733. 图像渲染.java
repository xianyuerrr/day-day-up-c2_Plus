import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
        };
        int m = image.length, n = image[0].length;
        boolean [][] visited = new boolean[m][n];
        Queue<int []> q = new ArrayDeque<>();
        int target = image[sr][sc];
        q.offer(new int [] {sr, sc});
        while (!q.isEmpty()) {
            int [] ans = q.poll();
            int x = ans[0], y = ans[1];
            visited[x][y] = true;
            image[x][y] = color;
            for (int [] dir : directions) {
                int nextX = x + dir[0], nextY = y + dir[1];
                if (nextX < 0 || nextX >= m) continue;
                if (nextY < 0 || nextY >= n) continue;
                if (!visited[nextX][nextY] && image[nextX][nextY] == target) {
                    q.offer(new int [] {nextX, nextY});
                }
            }
        }
        return image;
    }
}