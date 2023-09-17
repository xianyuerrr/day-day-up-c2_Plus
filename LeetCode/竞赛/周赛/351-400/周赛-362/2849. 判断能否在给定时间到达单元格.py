class Solution:
    def isReachableAtTime(self, sx: int, sy: int, fx: int, fy: int, t: int) -> bool:
        deleteX = abs(fx - sx)
        deleteY = abs(fy - sy)
        x = max(deleteX, deleteY)
        if x == 0 and t == 1:
            return False
        return t >= x