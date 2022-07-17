import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            if (dp[i] != -1) continue;
            int ans = 0;
            while (dp[i] == -1 && nums[i] != nums[nums[i]]) {
                dp[i] = 0;
                ans++;
                i = nums[i];
            }
            if (dp[i] == -1) ans++;
            res = Math.max(res, ans);
        }
        return res;
    }
}