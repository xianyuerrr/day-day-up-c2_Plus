import java.util.HashSet;
import java.util.Set;

class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] lis = sentence.split(" ");
        StringBuilder suffix = new StringBuilder("ma");
        for (int i = 0; i < lis.length; i++) {
            suffix.append("a");
            StringBuilder ans;
            if (!set.contains(lis[i].charAt(0))) {
                ans = new StringBuilder(lis[i].substring(1));
                ans.append(lis[i].charAt(0));
            } else {
                ans = new StringBuilder(lis[i]);
            }
            ans.append(suffix);
            lis[i] = ans.toString();
        }
        return String.join(" ", lis);
    }
}