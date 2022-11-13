import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    {
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int idx = map.getOrDefault(ruleKey, -1);
        if (idx < 0) return res;
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) res++;
        }
        return res;
    }
}