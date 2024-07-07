class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i];
            min = Math.min(min, res);
        }
        return -min + 1;
    }
}