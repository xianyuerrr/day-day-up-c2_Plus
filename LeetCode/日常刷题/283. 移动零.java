class Solution {
    public void moveZeroes(int[] nums) {
        int m =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) swap(nums, i, m++);
        }
        return;
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