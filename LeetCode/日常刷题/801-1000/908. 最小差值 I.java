class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int res = max - min - k * 2;
        return res > 0 ? res : 0;
    }
}