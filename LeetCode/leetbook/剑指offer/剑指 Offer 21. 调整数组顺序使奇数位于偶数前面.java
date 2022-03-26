class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int l=0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) {
                swap(nums, i, l++);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) return;
        if (i == j) return;
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
        return;
    }
}