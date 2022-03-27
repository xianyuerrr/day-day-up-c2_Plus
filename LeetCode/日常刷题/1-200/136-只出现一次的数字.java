class Solution {
    public int singleNumber(int[] nums) {
        // 异或运算
        int res = Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
        return res;
    }
}