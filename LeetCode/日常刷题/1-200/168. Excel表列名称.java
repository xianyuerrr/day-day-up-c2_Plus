class Solution {
    public String convertToTitle(int columnNumber) {
        // 26 -> Z
        // 27 -> AA

        // 数学证明
        // 本质上就是进制转换的拓展
        // columnNumber = ai * base**i (i = 0, 1, 2, ...)
        // 对任意 ai 都有： 1 <= ai  <= base
        // columnNumber - 1 = a0 - 1 + base * nxtCol
        // 0 <= a0 - 1 <= 25


        final int base = 26;
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0) {
            int ans = columnNumber % base;
            ans = ans == 0 ? base : ans;
            str.append((char) ('A' - 1 + ans));

            // 由于 0 映射到 26，ans == 0，那么 str 就会多一位 Z，如果不减掉，就会大 26
            columnNumber = (columnNumber - ans) / base;
        }
        return str.reverse().toString();
    }
}