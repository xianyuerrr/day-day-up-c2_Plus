class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[res]) {
                continue;
            } else {
                swap(nums, i, ++res);
            }
        }
        return res+1;
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