import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calPoints(String[] ops) {
        // 时空双 O(n)
        // 无法优化时间，因为至少要遍历一遍 ops 数组
        // 无法优化空间，因为不确定有多少 "C" 操作
        int res = 0;
        List<Integer> lis = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                lis.add(lis.get(n-2) + lis.get(n-1));
                n++;
            } else if (ops[i].equals("D")) {
                lis.add(2 * lis.get(n-1));
                n++;
            } else if (ops[i].equals("C")) {
                lis.remove(n-1);
                n--;
            } else {
                // System.out.println("未知操作");
                lis.add(Integer.valueOf(ops[i]));
                n++;
            }
        }
        for (int num : lis) {
            res += num;
        }
        return res;
    }
}