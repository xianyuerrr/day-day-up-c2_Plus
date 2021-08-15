class Solution:
    @lru_cache()
    def colorTheGrid(self, m: int, n: int) -> int:
        # 1:红
        # 2:绿
        # 3:蓝
        mod = pow(10, 9) + 7
        if n == 1:
            return 3
        elif n == 2:
            return pow(3, m) * 2
        else:
            return ((m+2) * self.colorTheGrid(m, n-1) - (3 - (m%2)) * self.colorTheGrid(m, n-2)) % mod