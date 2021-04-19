class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        m_bit = pow(2, maximumBit) - 1
        n = len(nums)
        res = [0 for _ in range(n)]
        ans = 0
        for i in range(n):
            ans ^= nums[i]
            print(ans)
            res[n-1-i] = m_bit ^ ans
        return res
