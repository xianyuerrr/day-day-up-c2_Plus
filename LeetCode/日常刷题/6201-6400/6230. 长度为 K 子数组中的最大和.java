import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        int l=0;
        long sum = 0;
        int[] preIdx = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            preIdx[i] = map.getOrDefault(nums[i], i);
            map.put(nums[i], i);
        }
        for (int r = 0; r < n; r++) {
            if (preIdx[r] != r && preIdx[r] >= l) {
                l = r;
                sum = 0;
            }
            sum += nums[r];
            if (k == r - l + 1) {
                res = Math.max(res, sum);
                sum -= nums[l++];
            }
        }
        return res;
    }
}