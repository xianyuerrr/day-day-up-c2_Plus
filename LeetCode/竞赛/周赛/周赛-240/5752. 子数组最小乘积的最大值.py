class Solution:
    def maxSumMinProduct(self, nums: List[int]) -> int:
        n = len(nums)
        pre_sum = [0 for _ in range(n+1)]
        for i in range(1, n+1):
            pre_sum[i] += pre_sum[i-1] + nums[i-1]
        
        def sub_res(nums, left, right):
            if left == right:
                return nums[left] * nums[left]
            elif left > right:
                return 0
            ssum = pre_sum[right+1] - pre_sum[left]
            mmin = min(nums[left : right+1])

            res = ssum * mmin
            l = left
            for i in range(left, right+1):
                if nums[i] == mmin:
                    res = max(res, sub_res(nums, l, i-1))
                    l = i + 1
            if l < right:
                res = max(res, sub_res(nums, l, right))
            return res
        

        return sub_res(nums, 0, n-1) % (pow(10, 9) + 7)