class Solution {
    public int missingNumber(int[] nums) {
        // 顺序遍历，二分
        int n = nums.length;
        int l = 0, r = n-1, m;
        while (l < r) {
            m = l + ((r-l) >> 1);
            if (nums[m] == m) l = m+1;
            else r = m;
        }
        return nums[l] != l ? l : n;
    }
}