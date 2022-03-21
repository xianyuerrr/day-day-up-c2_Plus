import java.util.Arrays;

class Solution {
    public int arraySign(int[] nums) {
        int res=1;
        // res = Arrays.stream(nums).reduce(1, (x, y) -> x*y > 0 ? 1 : (x == 0 || y == 0 ? 0 : -1));
        for (int num : nums) {
            res = res*num > 0 ? 1 : (res == 0 || num == 0 ? 0 : -1);
        }
        return res > 0 ? 1 : (res < 0 ? -1 : 0);
    }
}