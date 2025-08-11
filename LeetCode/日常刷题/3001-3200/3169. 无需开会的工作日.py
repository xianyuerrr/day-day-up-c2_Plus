from typing import List


class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x: (x[0], x[1]))
        l = 1
        res = 0
        for start, end in meetings:
            if start > l:
                res += start - l
                l = end + 1
            else:
                l = max(l, end + 1)
        return res if l > days else (res + days - l + 1)