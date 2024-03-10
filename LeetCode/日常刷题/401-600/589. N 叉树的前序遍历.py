"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

from typing import List
from collections import *


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        stk = Stack()
        res = [root.val]
        for child in root.children:
            res += self.preorder(child)
        return res