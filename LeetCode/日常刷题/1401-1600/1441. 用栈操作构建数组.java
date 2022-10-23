import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";

        List<String> res = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < target.length; i++) {
            while (cur != target[i]) {
                cur++;
                res.add(PUSH);
                res.add(POP);
            }
            cur++;
            res.add(PUSH);
        }
        return res;
    }
}