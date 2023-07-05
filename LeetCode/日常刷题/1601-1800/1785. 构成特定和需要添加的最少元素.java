class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i: nums) {
            sum += i;
        }
        long diff = Math.abs(goal - sum);
        int res = (int) (diff / limit) + (diff % limit != 0 ? 1 : 0);
        return res;
    }
}