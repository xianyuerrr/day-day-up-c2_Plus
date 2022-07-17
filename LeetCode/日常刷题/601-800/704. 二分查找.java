class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while (l < r) {
            int m = l + (r-l >> 1);
            if (nums[m] == target) {
                l = m;
                r = m;
            } else if (nums[m] < target) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}