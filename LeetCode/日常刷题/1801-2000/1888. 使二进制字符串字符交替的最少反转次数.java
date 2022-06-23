import java.lang.annotation.Target;

class Solution {
    public int minFlips(String s) {
        int res = Integer.MAX_VALUE;
        int n = s.length();
        char [] cs = s.toCharArray();
        final char [] TARGETA = new char [] {'0', '1'};
        final char [] TARGETB = new char [] {'1', '0'};
        int l = 0, r = n-1;
        int cntA = cnt(cs, l, r, TARGETA), cntB = cnt(cs, l, r, TARGETB);
        res = Math.min(res, Math.min(cntA, cntB));

        if ((n & 1) == 0) return res;
        
        while (r < 2 * n) {
            r++;
            int A = cntB - (cs[l % n] ^ '1') + (cs[r % n] ^ TARGETB[n & 1]);
            int B = cntA - (cs[l % n] ^ '0') + (cs[r % n] ^ TARGETA[n & 1]);
            cntA = A; cntB = B;
            res = Math.min(res, Math.min(cntA, cntB));
            l++;
        }
        return res;
    }

    private int cnt(char [] cs, int l, int r, char [] target) {
        int res = 0;
        int n = cs.length;
        for (int i = l, j = 0; i <= r; i++) {
            if (cs[i % n] != target[(j++) & 1]) res++;
        }
        return res;
    }
}