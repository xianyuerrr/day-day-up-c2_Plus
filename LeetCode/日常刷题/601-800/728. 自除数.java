import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int ans = i;
            while (ans != 0) {
                if (ans % 10 == 0 || i % (ans % 10) != 0) break;
                ans /= 10;
            }
            if (ans == 0) res.add(i);
        }
        return res;
    }
}