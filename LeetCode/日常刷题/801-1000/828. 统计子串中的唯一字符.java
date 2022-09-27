import java.util.ArrayList;
import java.util.List;

class Solution {
    public int uniqueLetterString(String s) {
        int res = 0;
        int n = s.length();
        List<Integer> [] map = new List[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map[c - 'A'] == null) {
                map[c - 'A'] = new ArrayList<>();
                map[c - 'A'].add(-1);
                map[c - 'A'].add(i);
            } else {
                map[c - 'A'].add(i);
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null) {
                map[i].add(n);
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) {
                continue;
            }
            for (int j = 1; j < map[i].size() - 1; j++) {
                int x = map[i].get(j-1), y = map[i].get(j), z = map[i].get(j+1);
                res += (y - x) * (z - y);
            }
        }
        return res;
    }
}