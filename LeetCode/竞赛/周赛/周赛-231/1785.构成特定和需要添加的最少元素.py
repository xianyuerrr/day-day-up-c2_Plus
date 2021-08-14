import math
class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        ssum = sum(nums) 
        return math.ceil(abs(goal - ssum) // limit)