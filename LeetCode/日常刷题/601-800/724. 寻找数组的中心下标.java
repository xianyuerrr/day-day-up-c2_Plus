class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) sum += nums[i];
        for (int i = 0; i < n; i++) {
            if (ans + ans == sum - nums[i]) return i;
            ans += nums[i];
        }
        return -1;
    }
}