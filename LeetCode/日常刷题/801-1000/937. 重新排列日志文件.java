import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int l = logs.length;
        List<String> dig = new ArrayList<>();
        List<String> let = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.charAt(log.length()-1))) dig.add(log);
            else let.add(log);
        }
        let.sort((x, y) -> {
            int ans = x.substring(x.indexOf(" ") + 1).compareTo(y.substring(y.indexOf(" ") + 1));
            return ans != 0 ? ans : x.compareTo(y);
        });
        let.addAll(dig);

        return let.toArray(new String[0]);
    }
}