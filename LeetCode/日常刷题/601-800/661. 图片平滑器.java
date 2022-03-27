class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int [][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt=0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!(i+x >= 0 && i+x < m && j+y >= 0 && j+y < n)) continue;
                        cnt++;
                        res[i][j] += img[i+x][j+y];
                    }
                }
                res[i][j] /= cnt;
            }
        }
        return res;
    }
}