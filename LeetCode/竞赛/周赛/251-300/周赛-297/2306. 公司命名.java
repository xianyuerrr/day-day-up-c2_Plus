import java.util.HashMap;
import java.util.Map;

class Solution {
    public long distinctNames(String[] ideas) {
        // 2 <= ideas.length <= 5 * 10**4

        // axx, bxx
        // ayy, cyy

        long res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String s: ideas) {
            String group = s.substring(1);
            map.putIfAbsent(group, 0);
            map.put(group, map.get(group) | 1 << (s.charAt(0) - 'a'));
        }
        // 组中首字母不包含 i 但包含 j 的组的个数
        int [][] cnt = new int [26][26];
        for (String key : map.keySet()) {
            int val = map.get(key);
            for (int i = 0; i < 26; i++) {
                short flagA = (short) (val >> i & 1);
                for (int j = 0; j < 26; j++) {
                    short flagB = (short) (val >> j & 1);
                    if ((flagA ^ flagB) == 0) continue;
                    else if (flagA == 1 && flagB == 0) res += cnt[i][j];
                    else if (flagA == 0 && flagB == 1) cnt[i][j]++;
                }
            }
        }
        return res * 2;
    }
}