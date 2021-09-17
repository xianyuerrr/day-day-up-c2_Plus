class Node:
    def __init__(self, val=-1):
        self.val = val
        self.pre = None
        self.nxt = None

head = node = Node(0)
for i in range(1, 201):
    newNode = Node(i)
    newNode.pre = node
    node.nxt = newNode
    node = node.nxt
    if i == 200:
        node.nxt = head.nxt
        head.nxt.pre = node
begin = head.nxt.nxt
cnt = 200
while cnt != 1:
    if cnt == 2:
        res = begin.nxt.val
        break
    nxtBegin = begin.nxt.nxt
    begin.pre.nxt = begin.nxt
    begin.nxt.pre = begin.pre
    begin = nxtBegin
    cnt -= 1
print(res)
