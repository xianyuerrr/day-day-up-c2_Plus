def findLeftTree(root):
    if root.right:
        return findLeftTree(root.right)
    return root.val

def findRightTree(root):
    if root.left:
        return findRightTree(root.right)
    return root.val

def check(root):
    if not root:
        return True
    l = check(root.left)
    r = check(root.right)
    if not (l and r):
        return False
    if root.left:
        if findLeftTree(root.left) > root.val:
            return False
    if root.right:
        if findRightTree(root.right) < root.val:
            return False
    return True

class Node:
    def __init__(self, val=0):
        self.val = val
        self.left = None
        self.right = None
        
def makeTree(lis, idx=0):
    root = Node(lis[idx])
    if (idx + 1) * 2 <= len(lis):
        root.left = makeTree(lis, (idx+1)*2 -1 )
    if (idx+1) * 2 + 1 <= len(lis):
        root.right = makeTree(lis, (idx+1) * 2 + 1 - 1)
    return root

lis = [5, 3, 10, 1, 4, 6, 12]
root = makeTree(lis)
print(check(root))