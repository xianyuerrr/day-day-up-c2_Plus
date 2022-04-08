class Solution {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 0) return -1;
        if (k <= 0) return nums[0];
        if (nums.length == 1 && (k & 1) == 1) return -1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < k-1 && i < nums.length; i++) {
            res = Math.max(res, nums[i]);
        }
        if (k < nums.length) res = Math.max(res, nums[k]);
        return res;
    }
}