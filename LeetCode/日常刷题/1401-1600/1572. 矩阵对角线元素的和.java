class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        // int res=0;
        int res = (n & 1) == 1 ? -mat[n>>1][n>>1] : 0;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            // res += i != n-1-i ? mat[i][n-1-i] : 0;
            res += mat[i][n-1-i];
        }
        return res;
    }
}