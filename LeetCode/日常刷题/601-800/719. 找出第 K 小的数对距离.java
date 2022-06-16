import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        return method1(nums, k);
    }

    /**
     * @Description 排序+二分+双指针
     */
    public int method1(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n-1] - nums[0], m;
        while (l < r) {
            m = l + (r - l >> 1);
            if (cntSmallsDistance(nums, m) < k) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int cntSmallsDistance(int [] nums, int distance) {
        int res = 0;
        int n = nums.length;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= distance) {
                j++;
            }
            res += j-i-1;
        }
        return res;
    }
}