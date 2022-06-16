import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int res = 0;
        int n = heights.length;
        int [] expected = heights.clone();
        Arrays.sort(expected);
        for (int i = 0; i < n; i++) {
            if (expected[i] != heights[i]) res++;
        }
        return res;
    }
}