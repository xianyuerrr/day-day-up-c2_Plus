class Solution {
    public int minimumNumbers(int num, int k) {
        // 每个整数个位数字都是 k
        // 所有整数之和是 num
        // 返回该多重集的最小大小，如果不存在这样的多重集，返回 -1
        // 除个位之外，其它位置不重要，只要 k * 个数 小于等于 num，就总能够凑出对应多重集
        if (num == 0) return 0;
        int ans = 0;
        for (int i = 1; i <= 10; i++) {
            ans += k;
            if (ans > num || (i != 1 && ans % 10 == k)) return -1;
            if (ans % 10 == num % 10) return i;
        }
        return -1;
        // 1 2 3 4 5 6 7 8 9 0
        // 2 4 6 8 0
        // 3 6 9 2 5 8 1 4 7 0
        // 4 8 2 6 0
        // 5 0
        // 6 2 8 4 0
        // 7 4 1 8 5 2 9 6 3 0
        // 8 6 4 2 0
        // 9 8 7 6 5 4 3 2 1 0
    }
}