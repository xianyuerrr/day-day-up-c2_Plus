import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // 长度相同 的单词
        // 找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
        // 不需要考虑 words 中单词串联的顺序, 也不能重复使用
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int len = words.length;
        int wordLen = words[0].length();
        // 1 <= n <= 10**4, 1 <= len <= 5000
        
        for (int begin = 0; begin < wordLen; begin++) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
            int l = begin;
            int wordCnt = 0;
            for (int r = begin; r + wordLen <= n; r += wordLen) {
                if ((r - l) == wordLen * len) {
                    String left = s.substring(l, l + wordLen);
                    if (map.containsKey(left)) {
                        map.put(left, map.get(left) + 1);
                        if (map.get(left) == 1) wordCnt--;
                    }
                    l += wordLen;
                }

                String right = s.substring(r, r + wordLen);
                if (map.containsKey(right)) {
                    map.put(right, map.get(right) - 1);
                    if (map.get(right) == 0) wordCnt++;
                    if (wordCnt == map.size()) res.add(l);
                }
            }
        }
        return res;
    }
}