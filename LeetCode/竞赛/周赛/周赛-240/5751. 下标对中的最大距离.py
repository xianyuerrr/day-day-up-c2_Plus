class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        m = len(nums1)
        n = len(nums2)
        res = 0
        for i in range(m):
            j = i + res
            while j < n-1 and nums1[i] <= nums2[j+1]:
                j += 1
            res = max(res, j-i)
            

        return res