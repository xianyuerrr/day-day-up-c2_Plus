class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while (l+1 < n && nums[l] <= nums[l+1]) l++;
        while (r-1+n > l && nums[(r+n) % n] >= nums[r-1+n]) r--;
        return l-r+1 == n;
    }
}