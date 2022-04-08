class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        // 朴素思想模拟
        // return method1(n, artifacts, dig);


        return method2(n, artifacts, dig);
    }

    public int method2(int n, int[][] artifacts, int[][] dig) {
        int res = 0;
        boolean [][] mat = new boolean [n] [n];

        int x, y;
        for (int i = 0; i < dig.length; i++) {
            x = dig[i][0];
            y = dig[i][1];
            mat[x][y] = true;
        }

        int x1, y1, x2, y2;
        for (int i = 0; i < artifacts.length; i++) {
            x1 = artifacts[i][0];
            y1 = artifacts[i][1];
            x2 = artifacts[i][2];
            y2 = artifacts[i][3];
            boolean flag = true;
            for (int xx = x1; xx <= x2; xx++) {
                for (int yy = y1; yy <= y2; yy++) {
                    if (mat[xx][yy]) continue;
                    flag = false;
                    break;
                }
                if (!flag) break;
            }
            if (flag) res++;
        }

        return res;
    }

    public int method1(int n, int[][] artifacts, int[][] dig) {
        n = artifacts.length;
        int [] cnt = new int [n];
        int res = 0;

        int x1, y1, x2, y2;
        for (int i = 0; i < n; i++) {
            x1 = artifacts[i][0];
            y1 = artifacts[i][1];
            x2 = artifacts[i][2];
            y2 = artifacts[i][3];
            cnt[i] = (x2-x1+1) * (y2-y1+1);
        }
        int x, y;
        for (int i = 0; i < dig.length; i++) {
            x = dig[i][0];
            y = dig[i][1];
            for (int j = 0; j < n; j++) {
                x1 = artifacts[j][0];
                y1 = artifacts[j][1];
                x2 = artifacts[j][2];
                y2 = artifacts[j][3];
                if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                    cnt[j]--;
                    if (cnt[j] == 0) res++;
                }
            }
        }
        return res;
    }
}