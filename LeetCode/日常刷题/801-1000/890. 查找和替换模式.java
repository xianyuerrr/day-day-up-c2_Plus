import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) res.add(word);
        }
        return res;
    }

    private boolean match(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m != n) return false;
        int [] lastIdxs1 = new int [26];
        int [] lastIdxs2 = new int [26];
        Arrays.fill(lastIdxs1, -1);
        Arrays.fill(lastIdxs2, -1);
        int lastIdx1, lastIdx2;
        for (int i = 0; i < m; i++) {
            lastIdx1 = word1.charAt(i) - 'a';
            lastIdx2 = word2.charAt(i) - 'a';
            if (lastIdxs1[lastIdx1] != lastIdxs2[lastIdx2]) return false;
            lastIdxs1[lastIdx1] = i;
            lastIdxs2[lastIdx2] = i;
        }
        return true;
    }
}