import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < numRows+1; i++) {
            List<Integer> ans = new ArrayList<>(i);
            ans.add(1);
            if (i > 2) {
                List<Integer> preLevel = res.get(i-1-1);
                for (int j = 0; j < i-1-1; j++) {
                    ans.add(preLevel.get(j) + preLevel.get(j+1));
                }
            }
            if (i > 1) ans.add(1);
            res.add(ans);
        }
        return res;
    }
}