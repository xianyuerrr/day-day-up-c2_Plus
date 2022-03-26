class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int cnt=5;
        while (cnt <= n)    {
            res += n / cnt;
            cnt *= 5;
        }
        return res;
    }
}