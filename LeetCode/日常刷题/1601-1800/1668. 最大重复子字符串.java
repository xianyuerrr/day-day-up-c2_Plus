class Solution {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n];
        for (int i = m-1; i < n; i++) {
            if (sequence.substring(i-m+1, i+1).equals(word)) {
                dp[i] = (i >= m ? dp[i-m] : 0) + 1;
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }
}