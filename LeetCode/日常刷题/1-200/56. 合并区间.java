import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int [] top = res.get(res.size()-1);
            if (top[1] >= intervals[i][1]) continue;
            else if (top[1] < intervals[i][0]) res.add(intervals[i]);
            else res.set(res.size()-1, new int [] {top[0], intervals[i][1]});
        }
        return res.toArray(new int[0][]);
    }
}   