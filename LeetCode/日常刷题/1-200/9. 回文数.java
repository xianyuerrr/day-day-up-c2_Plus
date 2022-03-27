class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;
        int res=0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        // 在此算法中， x*pow(10, y) 相当于 x，但其实 x 可能是 回文数，而 x*pow(10, y) 不可能是非 0 回文数
        return x == res || x == res / 10;
        // return x >= 0 && x == reverse(x);
    }

    private int reverse(int x) {
        int res=0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}