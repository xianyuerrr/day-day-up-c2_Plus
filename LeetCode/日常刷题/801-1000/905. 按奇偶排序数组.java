class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
        return;
    }

    public int[] sortArrayByParity(int[] nums) {
        // 双指针
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if ((nums[fast] & 1) == 0) swap(nums, slow++, fast);
        }
        return nums;
    }
}