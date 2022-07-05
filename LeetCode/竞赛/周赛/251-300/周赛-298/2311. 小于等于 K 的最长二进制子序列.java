import java.util.Arrays;

class Solution {
    public int longestSubsequence(String s, int k) {
        // 返回 s 的 最长 子序列，且该子序列对应的 二进制 数字小于等于 k
        // 子序列可以有 前导 0
        // 空字符串视为 0
        // 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列

        // s[i] 要么是 '0' ，要么是 '1'
        // 1 <= k <= 10^9
        // 1 <= n <= 1000
        return method2(s, k);
    }

    /**
     * description 贪心，O(n)
     */
    public int method2(String s, int k) {
        // 前导零不会改变二进制数的大小，因此要尽可能地往子序列前面添加前导零
        // 应该在 ss 中的一个靠后的位置找值不超过 k 的子序列，越靠后越好，因为这样前面能添加的前导零也就越多。
        int n = s.length(), m = 32 - Integer.numberOfLeadingZeros(k);
        if (n < m) return n;
        var ans = Integer.parseInt(s.substring(n - m), 2) <= k ? m : m - 1;
        return ans + (int) s.substring(0, n - m).chars().filter(c -> c == '0').count();
    }

    /**
     * description 动态规划，O(n^2)
     */
    public int method1(String s, int k) {
        int n = s.length();
        int res = 0;
        int [] dp = new int [n+1];
        // dp[i]: 长度为 i 的最长子序列对应的最小值
        Arrays.fill(dp, k + 1);
        dp[0] = 0;
        for (int i = 1; i < n+1; i++) {
            int val = (s.charAt(i-1) - '0');
            for (int j = i-1; j >=0; j--) {
                if ((dp[j] << 1 | val) > k) continue;

                if ((dp[j] << 1 | val) < dp[j+1]) dp[j+1] = dp[j] << 1 | val;
                else break;
                
                res = Math.max(res, j+1);
            }
        }
        return res;
    }
}