class Solution {
    public int search(int[] nums, int target) {
        int l = binarySearchLeft(nums, 0, nums.length-1, target);
        if (l == -1) return 0;
        int r = binarySearchRight(nums, 0, nums.length-1, target);
        return r - l + 1;
    }

    private int binarySearchLeft(int []nums, int l, int r, int target) {
        int m;
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] > target) r = m-1;
            else if (nums[m] < target) l = m+1;
            else r = m;
        }
        return l == r && nums[l] == target ? l : -1;
    }

    private int binarySearchRight(int []nums, int l, int r, int target) {
        int m;
        while (l < r) {
            m = l + (r-l+1 >> 1);
            if (nums[m] > target) r = m-1;
            else if (nums[m] < target) l = m+1;
            else l = m;
        }
        return l == r && nums[l] == target ? l : -1;
    }
}