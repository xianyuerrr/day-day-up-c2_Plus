class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        int m;
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] > nums[r]) l = m+1;
            else if (nums[m] < nums[r]) r = m;
            else l++;
        }
        int mid = l;
        if (nums[n-1] >= target) {
            l = mid;
            r = n-1;
        } else {
            l = 0;
            r = mid-1;
        }
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] == target) {
                l = m;
                r = m;
            } else if (nums[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l == r && nums[l] == target ? l : -1;
    }
}