from typing import *
from collections import *
from heapq import *


class Solution:
    def getReverse(self, num):
        res = 0
        while (num != 0):
            res = res * 10 + num % 10
            num //= 10
        return res

    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        n = len(queries)
        res = [0] * n
        cnt = (intLength+1) >> 1
        flag = intLength & 1
        base = pow(10, cnt-1)
        for i in range(n):
            # if (base+queries[i] - 1 >= base*10):
            if (queries[i] > base * 9):
                res[i] = -1
                continue
            num = base + queries[i] - 1
            reversed = self.getReverse(num // 10 if flag else num)
            res[i] = num * pow(10, (cnt-1 if flag else cnt)) + reversed
        return res


def main():
    # s = Solution()
    print(1)


if __name__ == '__main__':
    main()
