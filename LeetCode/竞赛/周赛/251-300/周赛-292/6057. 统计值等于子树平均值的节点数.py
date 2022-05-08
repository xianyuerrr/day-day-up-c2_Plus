# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        res = 0

        def dfs(root):
            nonlocal res
            if not root: return 0, 0
            lSsum, lCnt = dfs(root.left)
            rSsum, rCnt = dfs(root.right)
            ssum = root.val + lSsum + rSsum
            cnt = 1 + lCnt + rCnt
            if (root.val == ssum // cnt): res += 1
            return ssum, cnt
        dfs(root)
        return res


