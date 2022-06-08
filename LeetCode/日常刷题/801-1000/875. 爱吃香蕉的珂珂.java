class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 二分
        int l = 1, r = Integer.MAX_VALUE, mid;
        while (l < r) {
            mid = l + (r-l >> 1 + 1);
            if (check(piles, h, mid)) r = mid;
            else l = mid+1;
        }

        return l;
    }

    private boolean check(int [] piles, int h, int k) {
        for (int i = 0; i < piles.length; i++) {
            h -= piles[i] / k;
            if (piles[i] % k != 0) h--;
            if (h < 0) return false;
        }
        return true;
    }
}