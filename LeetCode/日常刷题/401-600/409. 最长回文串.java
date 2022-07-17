class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        int n = s.length();
        int [] cnt = new int[128];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i)] += 1;
        }
        for (int i = 0; i < 128; i++) {
            int ans = 2 * (cnt[i] / 2);
            res += ans;
            n -= ans;
        }
        return n == 0 ? res : res + 1;
    }
}