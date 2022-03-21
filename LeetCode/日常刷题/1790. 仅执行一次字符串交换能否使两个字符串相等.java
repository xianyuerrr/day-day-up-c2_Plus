import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int m, n;
        m = s1.length(); n = s2.length();
        if (m != n) return false;
        
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) lis.add(i);
        }
        if (lis.size() == 0) return true;
        if (lis.size() != 2) return false;
        if (s1.charAt(lis.get(0)) != s2.charAt(lis.get(1)) || 
            s1.charAt(lis.get(1)) != s2.charAt(lis.get(0))) return false;
        return true;
    }
}