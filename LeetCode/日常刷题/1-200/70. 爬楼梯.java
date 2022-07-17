class Solution {
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int x=1, y=1;
        for (int i = 1; i < n; i++) {
            int ans = x + y;
            x = y;
            y = ans;
        }
        return y;
    }
}