import java.util.Arrays;
import java.util.Random;

class Solution {
    Random random = new Random();
    public void wiggleSort(int[] nums) {
        method1(nums);
    }

    public void method1(int[] nums) {
        int n = nums.length;
        // 数组中相同元素的数目最多不超过 (n+1) / 2 个
        // 令 x = (n+1) / 2 -> nums[i] < nums[i+x]
        int [] arr = nums.clone();
        Arrays.sort(arr);
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    private int qSort(int [] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        swap(nums, l, l + random.nextInt(r-l+1));
        int ans = l;
        for (int i = l; i < nums.length; i++) {
            if (nums[i] <= nums[l]) swap(nums, i, ans++);
        }
        swap(nums, l, ans);
        if (ans == k) return nums[ans];
        else if (ans > k) return qSort(nums, l, ans-1, k);
        else return qSort(nums, ans+1, r, k);
    }

    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) return;
        if (i == j) return;
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
        return;
    }
}