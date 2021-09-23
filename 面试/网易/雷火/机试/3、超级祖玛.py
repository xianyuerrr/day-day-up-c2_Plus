from collections import defaultdict
def func():
    l1, l2, m = list(map(int, input().split()))
    have = list(input())
    queue = list(input())
    res = 0

    stk = []
    cnt = []
    l = r = 0
    n = len(have)
    dic = defaultdict(list)
    while r < n:
        while r < n and have[r+1] == have[l]:
            r += 1
        stk.append(have[l])
        cnt.append(r-l)
        l = r
    

