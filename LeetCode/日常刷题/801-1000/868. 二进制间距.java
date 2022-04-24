class Solution {
    public int binaryGap(int n) {
        int res = 0;
        int l = -1;
        int idx = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (l != -1) res = Math.max(res, idx-l);
                l = idx;
            }
            idx++;
            n >>= 1;
        }
        return res;
    }
}