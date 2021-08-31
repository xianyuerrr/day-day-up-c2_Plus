class Solution:
    def qpow(self, x, y, m):
        res = 1
        while y:
            if y & 1:
                res = res * x % m
            y >>= 1
            x = x * x % m
        return res
                
    def minNonZeroProduct(self, p: int) -> int:
        n = (pow(2, p)-1)
        m = pow(10, 9) + 7
        return self.qpow(n-1, (n-1)//2, m) * n % m
