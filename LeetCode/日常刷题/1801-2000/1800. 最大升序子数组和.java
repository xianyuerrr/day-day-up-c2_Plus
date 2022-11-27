class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        int left = 0;
        int ans = nums[0];
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > nums[right-1]) ans += nums[right];
            else {
                res = Math.max(res, ans);
                ans = nums[right];
                left = right;
            }
        }
        res = Math.max(res, ans);
        return res;
    }
}