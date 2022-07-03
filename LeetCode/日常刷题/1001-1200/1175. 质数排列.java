class Solution {
    
    public int numPrimeArrangements(int n) {
        // 1 到 n，质数放在质数索引（从1开始），计算方案总数
        // 计算质数数量，然后两部分用数学排列组合计算后相乘
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)) cnt++;
        }
        int mod = (int) Math.pow(10, 9) + 7;
        long res = 1;
        
        for (int i = cnt; i > 0; i--) {
            res = (res * i) % mod;
        }
        for (int i = n-cnt; i > 0; i--) {
            res = (res * i) % mod;
        }
        return (int) res;
    }

    private boolean isPrimeNumber(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}