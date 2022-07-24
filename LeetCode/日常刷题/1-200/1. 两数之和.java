import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Integer [] idxs = new Integer[n];
        for (int i = 0; i < n; i++) idxs[i] = i;
        Arrays.sort(idxs, (x, y) -> nums[x] - nums[y]);
        int l = 0, r = n-1;
        while (l < r) {
            int ans = nums[idxs[l]] + nums[idxs[r]];
            if (ans == target) break;
            else if (ans > target) r--;
            else l++;
        }
        return new int[] {idxs[l], idxs[r]};
    }
}