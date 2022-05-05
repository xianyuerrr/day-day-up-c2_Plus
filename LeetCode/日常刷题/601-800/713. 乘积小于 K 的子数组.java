class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 1 <= nums.length <= 3 * 10**4
        // 1 <= nums[i] <= 1000
        // 0 <= k <= 10**6
        // 朴素解法是遍历每个子数组的开头和结尾，计算乘积是否小于k
        // 但显然，这样长度的 nums 使用这种方法会超时

        // 由于 nums[i] 始终大于 1，子数组乘积就有了单调性，我们可以使用双指针的方法
        int n = nums.length;
        int res = 0;
        int slow=0;
        int mul = 1;
        for (int fast = 0; fast < n; fast++) {
            mul *= nums[fast];
            while (slow <= fast && mul >= k) mul /= nums[slow++];
            int length = fast-slow+1;
            if (length > 0) res += length;
        }

        return res;
    }
}