class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        for a in range(n):
            for b in range(a+1, n):
                for c in range(b+1, n):
                    for d in range(c+1, n):
                        if nums[a] + nums[b] + nums[c] == nums[d]:
                            res += 1

        return res