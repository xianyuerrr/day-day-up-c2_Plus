import java.util.Arrays;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // n == aliceValues.length == bobValues.length
        // 1 <= n <= 10**5
        // 1 <= aliceValues[i], bobValues[i] <= 100
        // 不是从两边，所以不能用dp
        // 主要是思路的转换
        int n = aliceValues.length;
        int [] sum = new int [n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum[i] = aliceValues[i] + bobValues[i];
            res -= bobValues[i];
        }
        Arrays.sort(sum);
        boolean flag = true;
        for (int i = n-1; i >= 0; i--) {
            if (flag) res += sum[i];
            flag = !flag;
        }
        if (res == 0) return 0;
        else if (res > 0) return 1;
        else return -1;
    }
}