class Solution:
    def findGCD(self, nums: List[int]) -> int:
        x, y = min(nums), max(nums)
        def gcd(x, y):
            if x > y:
                return gcd(y, x)
            elif x == 0:
                return y
            x, y = y%x, x
            return gcd(x, y)
        return gcd(x, y)