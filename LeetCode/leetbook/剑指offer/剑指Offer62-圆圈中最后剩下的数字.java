class Solution {
    public int lastRemaining(int n, int m) {
        // 0, 1, ..., (m-1)%n, ..., n-1 
        // -> (m-1) % n + 1, ..., n-1, 0, 1, ..., (m-2) % n
        if (n == 1) return 0;
        // return ((m-1) % n + 1 + lastRemaining(n-1, m)) % n;
        return (m + lastRemaining(n-1, m)) % n;
    }
}
