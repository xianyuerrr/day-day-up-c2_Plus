class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        n = len(letters)
        l = 0
        r = n-1
        while l < r:
            mid = l + (r-l >> 1)
            if letters[mid] > target:
                r = mid
            else:
                l = mid + 1
        # 二分最后肯定是收缩到某个 idx，但是可能会出现所有的值都小于 target的情况
        # 这时候，l = r = n-1
        # 而当 n-1 是第一个大于 target 的 idx 时，二分也收敛到 n-1
        # 需要区分这两个
        return letters[l] if letters[l] > target else letters[0]
