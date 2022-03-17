class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 0) { return -1; }
        int val=nums[0], cnt=1;
        for (int i=1; i<n; i++) {
            if (cnt == 0) {
                val = nums[i];
                cnt++;
            } else {
                if (val == nums[i]) cnt++;
                else cnt--;
            }
        }
        return val;
    }
}