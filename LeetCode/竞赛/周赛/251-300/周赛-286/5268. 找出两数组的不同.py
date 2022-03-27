from typing import *
from collections import *
from heapq import *


class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        s1 = set(nums1)
        s2 = set(nums2)
        return [list(s1-s2), list(s2-s1)]


def main():
    s = Solution()
    nums1 = [1, 2]
    nums2 = [2, 3]
    s.findDifference(nums1, nums2)


if __name__ == '__main__':
    main()
