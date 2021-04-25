class Solution:
    def sumBase(self, n: int, k: int) -> int:
        ans = 0
        while n!= 0 and n % k == 0:
                n = n // k
        while n >= k:
            ans = ans * 10 + n % k
            n //= k
        ans = ans * 10 + n
        res = 0
        while ans > 0:
            res += ans % 10
            ans //= 10
        return res