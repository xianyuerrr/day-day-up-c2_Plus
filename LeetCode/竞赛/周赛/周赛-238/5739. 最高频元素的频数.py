class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        j = 0
        ssum = 0
        n = len(nums)
        res = 1
        for i in range(1, n):
            ssum += (nums[i] - nums[i-1]) * (i - j)
            while ssum > k:
                ssum -= nums[i] - nums[j]
                j += 1
            res = max(res, i - j + 1)
        return res
        # 竟然要使用DP
        # count = Counter(nums)
        # count_lis = list(count.items())
        # count_lis.sort(reverse=True)
        # n = len(count_lis)
        # ans = 1
        # res = 1
        # for i in range(n):
        #     have = k
        #     ans = count_lis[i][1]
        #     for j in range(i+1, n):
        #         if have >= (count_lis[i][0] - count_lis[j][0]) * count_lis[j][1]:
        #             ans += count_lis[j][1]
        #             have -= (count_lis[i][0] - count_lis[j][0]) * count_lis[j][1]
        #         else:
        #             ans += have // (count_lis[i][0] - count_lis[j][0])
        #             break
        #     res = max(res, ans)
        # return res