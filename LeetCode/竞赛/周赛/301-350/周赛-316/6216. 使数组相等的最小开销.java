import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        long sum = 0;
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == null) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            sum += cost[i];
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            ans += (long) cost[j] * (Math.abs(left - 1 - nums[j]));
        }
        long res = ans;
        long delte = -sum;
        for (int i = left; i <= right; i++) {
            ans += delte;
            res = Math.min(res, ans);
            if (map.get(i) != null) {
                for (int k : map.get(i)) {
                    delte += 2 * cost[k];
                }
            }
        }
        return res;
    }
}