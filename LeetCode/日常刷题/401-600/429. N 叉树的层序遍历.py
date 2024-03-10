"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

from collections import deque
from typing import List


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        res = []
        q = deque([root])
        while q:
            level = []
            cnt = len(q)
            for i in range(cnt):
                cur = q.popleft()
                level.append(cur.val)
                for child in cur.children:
                    q.append(child)
            res.append(level)
        return res;
                