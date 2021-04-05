class Solution:
    # 二分查找
    def bSeache(self, nums, x):
        left, right = 0, len(nums)-1
        # 不减 1 的话，mid+1 可能越界
        while left < right:
            mid = (left + right) // 2
            # 这式子也太厉害了
            # 综合了 m, m+1, x; m, x, m+1; x, m, m+1 三种情况
            if x - nums[mid] > - x + nums[mid+1]:
                left = mid+1
            else:
                right = mid
        return nums[left]

    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        n = len(nums1)
        nums1_set = set(nums1)
        sorted_nums1 = sorted(list(nums1_set))
        
        now = [abs(nums1[i] - nums2[i]) for i in range(n)]
        # print(now)
        res = sum(now)

        best = [0 for _ in range(n)]
        for i in range(n):
            best[i] = abs(nums2[i] - self.bSeache(sorted_nums1, nums2[i]))
        greater = [now[i] - best[i] for i in range(n)]
        # print(best)
        # print(greater)
        idx = greater.index(max(greater))
        res -= greater[idx]
        return res % (pow(10, 9)+7)