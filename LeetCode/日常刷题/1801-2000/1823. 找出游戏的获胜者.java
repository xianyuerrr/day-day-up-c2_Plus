class Solution {
    public int findTheWinner(int n, int k) {
        // 计数时需要 包含 起始时的那位小伙伴
        // 1, 2, ..., n
        // -> k+1, k+2, ..., n, 1, 2, ..., k-1
        if (n == 1) return 1;
        // 由于一共 n 个数，所以一定要对 n 取余映射才会比较简单
        int nxt = (k + findTheWinner(n-1, k)) % n;
        return nxt == 0 ? n : nxt;
    }

}