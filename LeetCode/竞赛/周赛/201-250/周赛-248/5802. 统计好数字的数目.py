class Solution:
    # 快速幂
    def qpow(self, x, y, m):
        res = 1
        while(y):
            if y & 1:
                res = res * x % m
            x = x * x % m
            y >>= 1
        return res
    
    def countGoodNumbers(self, n: int) -> int:
        mod = pow(10, 9) + 7
        a, b = 5, 4
        index_a, index_b = (n+1) // 2, n // 2
        return self.qpow(a, index_a, mod) * self.qpow(b, index_b, mod) % mod
   
    # dfs
    # @lru_cache()
    # def countGoodNumbers(self, n: int) -> int:
    #     # print(n)
    #     if n == 0:
    #         return 1
    #     elif n == 1:
    #         return 5
    #     elif n == 2:
    #         return 20
    #     if (n+1) // 2 % 2 == 0:
    #         return self.countGoodNumbers((n+1) // 2) * self.countGoodNumbers(n // 2) % (1000000007)
    #     else:
    #         return self.countGoodNumbers((n+1) // 2 + 1) * self.countGoodNumbers(n // 2 - 1) % (1000000007)
    
    # # 吴自华, python
    # def countGoodNumbers(self, n: int) -> int:
    #     return pow(5, (n + 1) // 2, 1000000007) * pow(4, n // 2, 1000000007) % 1000000007

