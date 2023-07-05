class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c-'0']++;
        }
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) - '0' != cnt[i]) return false;
        }
        return true;
    }
}