class Solution {
    public int fib(int n) {
        return method2(n);
    }

    /**
     * @description 递归
     */
    public int method1(int n) {
        if (n <= 1) return n;
        return method1(n-2) + method1(n-1);
    }

    /**
     * @description 非递归
     */
    public int method2(int n) {
        if (n == 0) return 0;
        int x=0, y=1;
        for (int i = 1; i < n; i++) {
            int ans = x + y;
            x = y;
            y = ans;
        }
        return y;
    }
}