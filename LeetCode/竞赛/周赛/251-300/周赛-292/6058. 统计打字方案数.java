import java.util.Map;


class Solution {
    
    public int countTexts(String pressedKeys) {
        Map<Character, Integer> map = Map.of('2', 3, '3', 3, 
            '4', 3, '5', 3, '6', 3, 
            '7', 4, '8', 3, '9', 4);
        
        final int mod = (int) Math.pow(10, 9) + 7;
        int n = pressedKeys.length();
        
        int [] dp = new int [n];
        for (int end = 0; end < n; end++) {
            char c = pressedKeys.charAt(end);
            for (int start = end; start > end - map.get(c); start--) {
                if (start >= 0 && c == pressedKeys.charAt(start)) {
                    dp[end] = (dp[end] + (start - 1 >= 0 ? dp[start-1] : 1)) % mod;
                } else {
                    break;
                }
            }
        }
        return dp[n-1];
    }
}