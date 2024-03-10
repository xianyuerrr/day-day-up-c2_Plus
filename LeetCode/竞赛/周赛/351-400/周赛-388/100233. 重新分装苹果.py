from typing import List


class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        apple_sum = sum(apple)
        if (apple_sum == 0):
            return 0
        capacity.sort(key=lambda x : -x)
        res = 0
        for c in capacity:
            apple_sum -= c
            res += 1
            if (apple_sum <= 0):
                break
        return res