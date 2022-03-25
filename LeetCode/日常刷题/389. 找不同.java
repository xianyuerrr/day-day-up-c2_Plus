import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        // 异或
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        res ^= t.charAt(t.length()-1);
        return res;

        // // 求差
        // char res = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     res += t.charAt(i);
        //     res -= s.charAt(i);
        // }
        // res += t.charAt(t.length()-1);
        // return res;


        // // 哈希表计数
        // Map<Character, Integer> map  = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        // }
        // for (int i = 0; i < t.length(); i++) {
        //     if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) return t.charAt(i);
        //     map.put(t.charAt(i), map.get(t.charAt(i))-1);
        // }
        // return '#';

        // // 排序
        // char [] arrayS = s.toCharArray();
        // char [] arrayT = t.toCharArray();
        // Arrays.sort(arrayS);
        // Arrays.sort(arrayT);
        // for (int i = 0; i < arrayS.length; i++) {
        //     if (arrayS[i] != arrayT[i]) return arrayT[i];
        // }
        // return arrayT[arrayT.length-1];
    }
}