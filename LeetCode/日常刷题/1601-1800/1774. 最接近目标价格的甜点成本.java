import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 必须选择 一种 冰激凌基料
        int n = baseCosts.length;
        // 可以添加 一种或多种 配料，也可以不添加任何配料
        int m = toppingCosts.length;
        // 每种类型的配料 最多两份
        // 1 <= n, m <= 10
        // 1 <= target <= 104
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> sset = new TreeSet<>((x, y) -> y-x);
            sset.add(baseCosts[i]);
            for (int j = 0; j < m; j++) {
                Set<Integer> newSset = new TreeSet<>((x, y) -> y-x);
                for (Integer item: sset) {
                    if (item > target) continue;
                    newSset.add(item + toppingCosts[j]);
                    newSset.add(item + (toppingCosts[j] << 1));
                }
                sset.addAll(newSset);
            }
            for (int item: sset) {
                int x = Math.abs(res - target);
                int y = Math.abs(item - target);
                if (x > y) res = item;
                else if (x == y) res = res > item ? item : res;
            }
        }
        return res;
    }
}