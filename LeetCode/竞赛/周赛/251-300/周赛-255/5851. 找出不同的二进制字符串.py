class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        ans = []
        can_sele = ['0', '1']
        n = len(nums)
        def dfs(idx):
            if idx == n:
                if ''.join(ans) not in nums:
                    return True
                return False
            for i in can_sele:
                ans.append(i)
                if dfs(idx+1):
                    return True
                ans.pop()
            return False
        dfs(0)
        return ''.join(ans)