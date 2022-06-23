class Solution {
    public boolean sumGame(String num) {
        // 两人轮流行动，Alice 先手
        int n = num.length();
        // n 为偶数，字符为数字字符或者 '?'，'?'可替换为数字字符
        // 当 num 中没有 '?' 时，游戏结束。
        // Bob 获胜的条件是 num 中前一半数字的和 等于 后一半数字的和。Alice 获胜的条件是前一半的和与后一半的和 不相等
        int sumL = 0, sumR =  0, cntL = 0, cntR = 0;
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (i < n >> 1) {
                if (c == '?') cntL++;
                else sumL += c - '0';
            } else {
                if (c == '?') cntR++;
                else sumR += c - '0';
            }
        }
        // 最后一个问号时一定只有一个数字能使两边相等
        if(((cntL + cntR) & 1) == 1) return true;
        // 如果两侧问号数相同，那么B只有在两侧和相同时才能获胜，e.g. 3+1, 4+1 不能使两侧相等
        // 如果两侧问号数不同，那么只有在其小于等于另一侧的值，且差至多小9*cntDiff/2时才能使两侧相等
        int diff = sumL - sumR;
        int cntDiff = cntL - cntR;
        if (diff < 0 && cntDiff <= 0) return true;
        if (diff > 0 && cntDiff >= 0) return true;
        int minAdd = 0, maxAdd = 0;
        // 只靠 A 就能填补差距
        minAdd = ((Math.abs(cntDiff) >> 1) + (Math.abs(cntDiff) & 1)) * 9;
        // 只靠 B 无法填补差距
        maxAdd = (Math.abs(cntDiff) >> 1) * 9;
        if (Math.abs(diff) < minAdd) return true;
        if (Math.abs(diff) > maxAdd) return true;
        return false;
    }
}