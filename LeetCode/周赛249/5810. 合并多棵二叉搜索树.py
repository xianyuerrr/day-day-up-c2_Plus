# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def canMerge(self, trees: List[TreeNode]) -> TreeNode:
        trees.sort(key=lambda x: x.val)
        