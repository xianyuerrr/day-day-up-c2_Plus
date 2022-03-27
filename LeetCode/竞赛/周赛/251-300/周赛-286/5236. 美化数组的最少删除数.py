from typing import *
from collections import *
from heapq import *


class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        n = len(nums)
        lis = []
        length = -1
        for num in nums:
            if length == -1 or length & 1:
                lis.append(num)
                length += 1
            else:
                if (lis[-1] == num):
                    continue
                lis.append(num)
                length += 1
        return (n - (len(lis) - 1) if len(lis) & 1 else (n - len(lis)))


def main():
    s = Solution()
    print(s)


if __name__ == '__main__':
    main()
