# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import Optional


class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.__cache = set()
        def dfs(node: TreeNode, val: int) -> None:
            if not node:
                return
            node.val = val
            self.__cache.add(node.val)
            dfs(node.left, val * 2 + 1)
            dfs(node.right, val * 2 + 2)
        
        dfs(root, 0)
        self.root = root

    def find(self, target: int) -> bool:
        return target in self.__cache



# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)