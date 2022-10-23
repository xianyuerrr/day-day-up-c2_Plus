import java.util.Arrays;

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int ans = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (ans < k || ans % k != 0) break;
                ans = gcm(ans, nums[j]);
                if (ans == k) {
                    res++;
                }
            }
        }
        return res;
    }

    private int gcm(int x, int y) {
        if (x > y) return gcm(y, x);
        int ans = y % x;
        if (x == 0 || x == 1 || ans == 0) return x;
        return gcm(ans, x);
    }
}