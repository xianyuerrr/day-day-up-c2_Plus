class Solution {
    public int longestContinuousSubstring(String s) {
        int res = 0;
        int length = s.length();
        int left = 0;
        for (int right = 1; right < length; right++) {
            if (s.charAt(right) != s.charAt(right - 1) + 1) {
                res = Math.max(res, right - left);
                left = right;
            }
        }
        res = Math.max(res, length - left);
        return res;
    }
}