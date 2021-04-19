class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        l = 0
        r = n-1

        while l < r:
            mid = l + (r-l >> 1)
            if arr[mid] == x:
                l = mid
                r = mid
            elif arr[mid] < x:
                l = mid + 1
            elif arr[mid] > x:
                r = mid
        new_l = max(0, l-k)
        new_r = min(n-1, l+k-1)
        while new_r - new_l + 1 > k:
            if x - arr[new_l] > arr[new_r] - x:
                new_l += 1
            else:
                new_r -= 1
        return arr[new_l : new_r+1]