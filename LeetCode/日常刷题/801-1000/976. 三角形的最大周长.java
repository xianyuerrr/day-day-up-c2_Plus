import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n-1; i >= 2; i--) {
            if (nums[i-1] + nums[i-2] > nums[i]) {
                res = nums[i] + nums[i-1] + nums[i-2];
                break;
            }
        }
        return res;
    }
}