class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        // 1 <= radius <= 50
        int n = 110;
        int[][] cnt = new int[n][n];
        int[] res = new int[] {0, 0};
        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];
            for (int i = Math.max(0, x - radius); i < x + radius + 1; i++) {
                for (int j = Math.max(0, y - radius); j < y + radius + 1; j++) {
                    double d = getDistance(x, y, i, j);
                    if (d <= radius) cnt[i][j] += q / (1 + d);
                    if (cnt[res[0]][res[1]] < cnt[i][j]) {
                        res[0] = i;
                        res[1] = j;
                    } else if (cnt[res[0]][res[1]] == cnt[i][j] && (i < res[0] || (i == res[0] && j < res[1]))) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
    }
}