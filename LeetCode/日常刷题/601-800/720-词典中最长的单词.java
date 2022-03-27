import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (String s : words) {
            String ss = s.substring(0, s.length()-1);
            if (set.contains(ss)) {
                set.add(s);
                if (res.length() < s.length()) res = s;
            }
        }
        return res;
    }
}
