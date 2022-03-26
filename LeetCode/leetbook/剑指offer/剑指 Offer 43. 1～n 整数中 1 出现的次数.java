class Solution {
    public int countDigitOne(int n) {
        // e.g. 1234 567
        // m: 100
        // l : 1, 2, ..., 1234
        // r: 567
        int res=0;
        long m=1;
        long l, r;
        l = n / (10 * m); r = n % (10 * m);
        while (m <= n) {
            res += l * m + Math.min(Math.max(r-m+1, 0), m);
            if (l == 0) break;
            m *= 10;
            l = n / (10 * m);
            r = n % (10 * m);
        }

        return res;
    }
}