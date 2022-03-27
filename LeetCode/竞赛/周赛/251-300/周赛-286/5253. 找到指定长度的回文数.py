from typing import *
from collections import *
from heapq import *


class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        n = len(queries)
        res = [0] * n
        cnt = (intLength+1) >> 1
        num = pow(10, cnt-1)
        for i in range(n):
            # if (num+queries[i] - 1 >= num*10):
            if (queries[i] >= num * 9):
                res[i] = -1
                continue
            num += queries[i] - 1
            nnum = num
            b = 0
            if (intLength & 1):
                nnum //= 10
            while (nnum != 0):
                b = b * 10 + nnum % 10
                nnum //= 10
            print(cnt, num, b)
            res[i] = num * pow(10, (cnt-1 if intLength & 1 else cnt)) + b
        return res


def main():
    # s = Solution()
    print(1)


if __name__ == '__main__':
    main()
