class Solution {
    public boolean isSubsequence(String s, String t) {
        // 可以用 dp 存储其下一个字符的下标，以优化时间复杂度
        int m = s.length(), n = t.length();
        int idx = 0;
        for (int i = 0; i < n && idx < m; i++) {
            if (s.charAt(idx) == t.charAt(i)) idx++;
        }
        return idx == m;
    }
}