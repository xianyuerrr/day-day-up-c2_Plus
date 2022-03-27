class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        n = len(weights)
        if n <= D:
            return max(weights)
        
        def last_idx(max_dly, D):
            have = max_dly
            for i in range(n):
                if have >= weights[i]:
                    have -= weights[i]
                else:
                    D -= 1
                    if D == 0:
                        return False
                    have = max_dly - weights[i]
            return True

        left = max(weights)
        right = left * n
        while left < right:
            mid = left + (right - left >> 1)
            if last_idx(mid, D):
                right = mid
            else:
                left = mid + 1
        return left
