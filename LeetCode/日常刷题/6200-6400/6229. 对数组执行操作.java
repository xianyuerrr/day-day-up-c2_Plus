class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] <<= 1;
                nums[i+1] = 0;
            }
        }
        int l = 0;
        int r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                r++;
                continue;
            }
            swap(nums, l++, r++);
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