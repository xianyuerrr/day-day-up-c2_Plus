import java.util.Arrays;

class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = Integer.MIN_VALUE;
        int[] minVal = new int[n];
        int rightMin = Integer.MAX_VALUE;
        for (int i = n-1; i > 0; i--) {
            rightMin = Math.min(rightMin, nums[i]);
            minVal[i] = rightMin;
        }
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax <= minVal[i+1]) return i+1;
        }
        return -1;
    }
}