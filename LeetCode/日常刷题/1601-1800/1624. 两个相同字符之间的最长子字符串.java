import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        int[] log = new int[26];
        Arrays.fill(log, -1);
        int length = s.length();
        for (int idx = 0; idx < length; idx++) {
            char c = s.charAt(idx);
            if (log[c - 'a'] != -1) {
                res = Math.max(res, idx - log[c - 'a'] - 1);
            } else {
                log[c - 'a'] = idx;
            }
        }
        return res;
    }
}
