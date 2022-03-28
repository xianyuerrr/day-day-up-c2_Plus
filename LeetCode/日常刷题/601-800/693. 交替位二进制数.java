class Solution {
    public boolean hasAlternatingBits(int n) {
        int flag = n & 1;
        while (n > 0) {
            if ((n & 1) != flag) return false;
            flag = flag ^ 1;
            n >>= 1;
        }
        return true;
    }
}