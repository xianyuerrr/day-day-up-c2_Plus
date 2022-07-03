import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // 输出值符合 32 位整数范围
        // 不同结果的数量不超过 10^4
        // 1 <= expression.length <= 20
        // expression 由数字和算符 '+'、'-' 和 '*' 组成
        // 输入表达式中的所有整数值在范围 [0, 99] 
        // return method1(expression);
        return method2(expression);
    }

    /**
     * @description 动态规划
     */
    public List<Integer> method2(String expression) {
        int n = expression.length();
        char [] ch = expression.toCharArray();
        List<Integer> [][] dp = new List [n][n];
        // 初始化
        int l = 0, val = 0;
        for (int r = 0; r < n; r++) {
            if (isOps(r, ch)) {
                dp[l][r-1] = List.of(val);
                l = r+1;
                val = 0;
            } else {
                val = val * 10 + (ch[r] - '0');
            }
        }
        dp[l][n-1] = List.of(val);

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 判断是否是合规的表达式
                if (!((i==0 || isOps(i-1, ch)) && (j == n-1 || isOps(j+1, ch)))) continue;
                if (dp[i][j] == null) dp[i][j] = new ArrayList<>();
                // 枚举符号，构建List
                for (int k = i+1; k < j; k++) {
                    if (isOps(k, ch)) {
                        for (int x : dp[i][k-1]) {
                            for (int y : dp[k+1][j]) {
                                if (ch[k] == '+') dp[i][j].add(x + y);
                                else if (ch[k] == '-') dp[i][j].add(x - y);
                                else if (ch[k] == '*') dp[i][j].add(x * y);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    /**
     * @description 爆搜
     */
    public List<Integer> method1(String expression) {
        int n = expression.length();
        char [] ch = expression.toCharArray();
        List<Integer> res = dfs(0, n-1, ch);
        return res;
    }

    private List<Integer> dfs(int l, int r, char [] ch) {
        if (isNumber(l, r, ch)) {
            int val = 0;
            for (int i = l; i < r+1; i++) {
                val = val * 10 + (ch[i] - '0');
            }
            return List.of(val);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l+1; i < r; i++) {
            if (isOps(i, ch)) {
                List<Integer> left = dfs(l, i-1, ch);
                List<Integer> right = dfs(i+1, r, ch);
                for (int x : left) {
                    for (int y : right) {
                        if (ch[i] == '+') res.add(x+y);
                        else if (ch[i] == '-') res.add(x-y);
                        else if (ch[i] == '*') res.add(x*y);
                    }
                }
            }
        }
        return res;
    }

    private boolean isNumber(int l, int r, char [] ch) {
        for (int i = l+1; i < r; i++) {
            if (isOps(i, ch)) return false;
        }
        return true;
    }

    private boolean isOps(int idx, char [] ch) {
        return ch[idx] == '+' || ch[idx] == '-' || ch[idx] == '*';
    }
}