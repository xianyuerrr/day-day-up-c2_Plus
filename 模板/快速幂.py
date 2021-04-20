class Solution:
    def myPow(self, x: float, n: int) -> float:
        # 经典快速幂
        if n == 0:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        res = 1
        while n > 1:
            if n % 2 == 1:
                res *= x
            x *= x
            n //= 2
        return x * res
