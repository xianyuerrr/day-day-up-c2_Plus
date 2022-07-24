import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return method2(s, p);
    }

    public List<Integer> method2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int l = 0;
        int [] cnt = new int[26];
        int x = m;
        for (int i = 0; i < m; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        for (int r = 0; r < n; r++) {
            int rIdx = s.charAt(r) - 'a';
            cnt[rIdx]--;
            if (cnt[rIdx] >= 0) x--;
            else x++;
            if (r - l + 1 == m) {
                if (x == 0) res.add(l);
                int lIdx = s.charAt(l++) - 'a';
                cnt[lIdx]++;
                if (cnt[lIdx] > 0) x++;
                else x--;
            } 
        }
        return res;
    }

    public List<Integer> method1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int l = 0;
        int [] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r) - 'a']--;
            if (r - l + 1 == m) {
                if (check(cnt)) res.add(l);
                cnt[s.charAt(l++) - 'a']++;
            }
        }
        return res;
    }

    private boolean check(int [] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}