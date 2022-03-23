class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) return mat;
        int [][] res = new int[r][c];
        int idx=-1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                idx++;
                // idx = i * mat[0].length + j;
                // x * c + y + 1 = idx = i * n + j + 1
                // x * c + y = i * n + j
                // x = idx / c; y = idx % c
                res[idx / c][idx % c] = mat[i][j];
            }
        }
        return res;
    }
}