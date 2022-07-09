import java.util.Arrays;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // s 和 t 由任意有效的 ASCII 字符组成
        // 同构: s 可以按某种映射关系替换得到 t
        int m = s.length(), n = t.length();
        if (m != n) return false;
        int [] sl = new int [128];
        int [] tl = new int [128];
        Arrays.fill(sl, -1);
        Arrays.fill(tl, -1);
        for (int i = 0; i < n; i++) {
            int sIdx = s.charAt(i);
            int tIdx = t.charAt(i);
            if (sl[sIdx] != tl[tIdx]) return false;
            sl[sIdx] = i;
            tl[tIdx] = i;
        }
        return true;
    }
}