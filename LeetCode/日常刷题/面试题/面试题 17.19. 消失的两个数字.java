import java.util.ArrayList;
import java.util.List;

class Solution {
    // 加法是不是也可以
    public int[] missingTwo(int[] nums) {
        int len = nums.length;
        int x = 0, y = 0;
        int cur = 0;
        for (int i = 1; i < len+3; i++) {
            cur ^= i;
        }
        for (int i = 0; i < len; i++) {
            cur ^= nums[i];
        }
        // cur ^= -cur;
        int cnt = 0;
        while ((cur & 1) != 1) {
            cnt++;
            cur >>= 1;
        }
        for (int i = 0; i < len; i++) {
            if ((nums[i] >> cnt & 1) == 1) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }
        }

        for (int i = 1; i < len+3; i++) {
            if ((i >> cnt & 1) == 1) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        return new int[] {x, y};
    }
}