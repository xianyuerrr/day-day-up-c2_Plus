import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        return method2(arr);

    }
    public int method1(int[] arr) {
        int n = arr.length;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(arr[i]);
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp.add(List.of(arr[j], arr[i]));
            }
        }
        while (dp.size() != 0) {
            res++;
            List<List<Integer>> nextDp = new ArrayList<>();
            for (List<Integer> lis : dp) {
                int x = lis.get(0), y = lis.get(1);
                if (set.contains(x + y)) {
                    nextDp.add(List.of(y, x+y));
                }
            }
            dp = nextDp;
        }
        return res <= 2 ? 0 : res;
    }

    public int method2(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > ans; j--) {
                if (arr[i] - arr[j] >= arr[j]) break;
                int t = map.getOrDefault(arr[i] - arr[j], -1);
                if (t == -1) continue;
                f[i][j] = Math.max(3, f[j][t] + 1);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }
}