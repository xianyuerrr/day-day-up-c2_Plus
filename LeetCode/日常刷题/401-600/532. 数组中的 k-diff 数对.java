import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findPairs(int[] nums, int k) {
        // 朴素解法
        // return method1(nums, k);
        // 排序+二分搜索
        // return method2(nums, k);
        // 排序+双指针
        return method3(nums, k);
    }

    public int method3(int[] nums, int k) {
        // 朴素解法
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        Set<Integer> set = new HashSet<>();
        for (int r = 1; r < n; r++) {
            while(l < r-1 && nums[r] - nums[l] > k) {
                l++;
            }
            if (!set.contains(nums[r]) && nums[r] - nums[l] == k) {
                res++;
                set.add(nums[r]);
            } 
        }
        return res;
    }

    public int method2(int[] nums, int k) {
        // 朴素解法
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = nums[i] + k;
            if (binarySearch(nums, i+1, n-1, target)) res++;
        }
        return res;
    }

    private boolean binarySearch(int []nums, int l, int r, int target) {
        int m;
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] > target) r = m-1;
            else if (nums[m] < target) l = m+1;
            else {l = m; r = m;}
        }
        return l == r && nums[l] == target;
    }

    public int method1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        for (int i : nums) {
            if (map.get(i) == 0) continue;
            if (k == 0) {
                if (map.get(i) > 1) res++;
            } else {
                int a = i - k, b = i + k;
                if (map.getOrDefault(a, 0) > 0) res++;
                if (map.getOrDefault(b, 0) > 0) res++;
            }
            map.put(i, 0);
        }
        return res;
    }
}