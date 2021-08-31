from heapq import *
class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        n = len(arr)
        counter = Counter(arr)

        left = 0
        right = min(n, max(arr))
        while left < right:
            mid = left + (right - left >> 1) + 1
            ans = 0
            for i in counter:
                if i > mid:
                    ans += counter[i]
            flag = True
            for i in range(mid, 0, -1):
                if ans < 0:
                    flag = False
                    break
                ans -= 1
                if i in counter:
                    ans += counter[i]
            if flag:
                left = mid
            else:
                right = mid-1
        return left