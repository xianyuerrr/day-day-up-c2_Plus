class Solution {
    public void rotate(int[][] matrix) {
        method3(matrix);
    }

    /**
     * description 翻转
     */
    public void method3(int[][] matrix) {
        // matrix 为 n × n 的二维矩阵
        // 顺时针旋转 90 度
        // 原地旋转
        int n = matrix.length;
        for (int i = 0; i < n >> 1; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return;
    }

    /**
     * description 取矩形四分之一区域
     */
    public void method2(int[][] matrix) {
        // matrix 为 n × n 的二维矩阵
        // 顺时针旋转 90 度
        // 原地旋转
        int n = matrix.length;
        // x, y 都属于第一象限
        // 旋转后: y, n-1-x
        // matrix_new[col][n−row−1]=matrix[row][col]
        for (int i = 0; i < (n + 1) >> 1; i++) {
            for (int j = 0; j < n >> 1; j++) {
                int ans = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = ans;
            }
        }
        return;
    }

    /**
     * description 取三角形四分之一区域
     */
    public void method1(int[][] matrix) {
        // matrix 为 n × n 的二维矩阵
        // 顺时针旋转 90 度
        // 原地旋转
        int n = matrix.length;
        // x, y 都属于第一象限
        // 旋转后: y, n-1-x
        // matrix_new[col][n−row−1]=matrix[row][col]
        // 取三角形的四分之一区域
        int l = 0, r = n-1;
        for (int i = 0; i < (n + 1) >> 1; i++) {
            for (int j = l; j < r; j++) {
                int ans = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = ans;
            }
            l++; r--;
        }
        return;
    }
}