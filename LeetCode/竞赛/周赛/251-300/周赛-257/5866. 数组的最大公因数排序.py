class Solution:
    def gcd(self, x, y):
        if x > y:
            return self.gcd(y, x)
        if y % x == 0:
            return x
        x, y = y%x, x
        return self.gcd(x, y)

    def gcdSort(self, nums: List[int]) -> bool:
        # nums = list(set(nums))
        n = len(nums)
