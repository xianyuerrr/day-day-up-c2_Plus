class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res += A(9, 1) * A(9, i-1);
        }
        return res;
    }

    private int A(int n, int k) {
        if (n <= k || k <= 0) return 1;
        return factorial(n) / factorial(n-k);
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n-1);
    }
}