import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // 两层遍历
        // return method1(intervals);
        // 排序二分
        return method2(intervals);
    }

    private int[] method2(int[][] intervals) {
        int n = intervals.length;
        int [] res = new int [n];
        Arrays.fill(res, -1);
        Integer [] lis = new Integer [n];
        for (int i = 0; i < n; i++) lis[i] = i;
        Arrays.sort(lis, (x, y) -> intervals[x][0] - intervals[y][0]);
        int l, r, m;
        for (int i = 0; i < n; i++) {
            l = 0; r = n-1;
            while (l < r) {
                m = l + (r-l >> 1);
                if (intervals[lis[m]][0] < intervals[i][1]) l = m+1;
                else r = m;
            }
            if (intervals[lis[l]][0] >= intervals[i][1]) res[i] = lis[l];
        }
        return res;
    }

    private int[] method1(int[][] intervals) {
        int n = intervals.length;
        int [] res = new int [n];
        Arrays.fill(res, -1);
        int val;
        for (int i = 0; i < n; i++) {
            val = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (intervals[j][0] >= intervals[i][1]) {
                    if (intervals[j][0] < val) {
                        res[i] = j;
                        val = intervals[j][0];
                    }
                }
            }
        }
        return res;
    }
}