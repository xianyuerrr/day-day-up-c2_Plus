class Solution {
    public int getKthMagicNumber(int k) {
        // 素因子只有3, 5, 7，2 不算，就只有奇数
        // 不可能是素数
        // 不是必须有3, 5, 7，但一定没有其他素数
        if (k == 1) return 1;
        int x = 3, y = 5, z = 7;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        int[] lis = new int[k];
        lis[0] = 1;
        int last = 0;
        while (last != k-1) {
            int staus = max(x, y, z);
            int val = 0;
            switch (staus) {
                case 0:
                    val = x;
                    if (val != lis[last]) {
                        lis[++last] = val;
                    }
                    x = idx1 < k-1 ? lis[++idx1] * 3 : x;
                    
                    break;
                case 1:
                    val = y;
                    if (val != lis[last]) {
                        lis[++last] = val;
                    }
                    y = idx2 < k-1 ? lis[++idx2] * 5 : y;
                    break;
                case 2:
                    val = z;
                    if (val != lis[last]) {
                        lis[++last] = val;
                    }
                    z = idx3 < k-1 ? lis[++idx3] * 7 : z;
                    break;
                default:
                    break;
            }
            if (val == lis[last]) continue;
            lis[++last] = val;
        }
        return lis[k-1];
    }

    private int max(int x, int y, int z) {
        if (x <= y && x <= z) return 0;
        if (y <= x && y <= z) return 1;
        if (z <= x && z <= y) return 2;
        return -1;
    }
}