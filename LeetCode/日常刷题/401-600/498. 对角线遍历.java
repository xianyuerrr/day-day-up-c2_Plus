class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int [] res = new int [m*n];
        int length = m * n;
        int i = 0, j = 0;
        int idx=0;
        while (true) {
            while (idx < length && i >= 0 && j < n) {
                // System.out.println(i + ", " + j + ", " + mat[i][j]);
                res[idx++] = mat[i--][j++];
            }
            i++; j--;
            if (j+1 < n) j++;
            else i++;

            while (idx < length && i < m && j >= 0) {
                // System.out.println(i + ", " + j + ", " + mat[i][j]);
                res[idx++] = mat[i++][j--];
            }
            i--; j++;
            if (i+1 < m) i++;
            else j++;

            if (idx == length) break;
        }
        return res;
    }
}