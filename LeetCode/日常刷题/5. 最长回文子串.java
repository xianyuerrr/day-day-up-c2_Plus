class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int l = 0, r = 0;
        // 中心扩展
        for (int i = 0; i < n; i++) {
            
        }

        // // dp
        // boolean [][] dp = new boolean [n][n];
        // for (int i = n-1; i >= 0; i--) {
        //     for (int j = i; j < n; j++) {
        //         if (i == j) dp[i][j] = true;
        //         else dp[i][j] = (i+1 != j ? dp[i+1][j-1] : true) && s.charAt(i) == s.charAt(j);
        //         if (dp[i][j] && j-i > r-l) { l=i; r=j; }
        //     }
        // }
        return s.substring(l, r+1);
    }
}