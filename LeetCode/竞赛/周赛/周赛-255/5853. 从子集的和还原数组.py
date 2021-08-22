class Solution:
    def recoverArray(self, n: int, sums: List[int]) -> List[int]:
        dic = {}
        for s in sums:
            dic[s] = True
        
