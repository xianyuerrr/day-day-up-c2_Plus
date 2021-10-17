class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        res = 0
        target = 0
        n= len(nums)
        for i in nums:
            target |= i
        for i in range(pow(2, n)):
            print('*' * 8, i)
            ans = 0
            for j in range(n):
                if i >> j & 1:
                    print(j, nums[j])
                    ans |= nums[j]
            if ans == target:
                res += 1
        return res