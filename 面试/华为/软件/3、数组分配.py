from collections import defaultdict

def myPrint(num, l):
    for i in range(l-1):
        print(num[i], end=' ')
    print(num[l-1])
    return

def func():
    s1 = list(map(int, input().split()))
    s2 = list(map(int, input().split()))
    m, n = len(s1), len(s2)
    dic1 = defaultdict(list)
    dic2 = defaultdict(list)
    for i in range(m):
        for j in range(i+1, m):
            diff = s1[j] - s1[i]
            if diff in dic1:
                continue
            subLis = [s1[i], s1[j]]
            for k in range(j+1, m):
                if s1[k] - subLis[-1] == diff:
                    subLis.append(s1[k])
            dic1[diff] = subLis

    for i in range(n):
        for j in range(i+1, n):
            diff = s2[j] - s2[i]
            if diff in dic2:
                continue
            subLis = [s2[i], s2[j]]
            for k in range(j+1, n):
                if s2[k] - subLis[-1] == diff:
                    subLis.append(s2[k])
            dic2[diff] = subLis

    res = 0
    subLis1 = []
    subLis2 = []

    for k, v in dic1.items():
        if k in dic2:
            sameLen = min(len(dic1[k]), len(dic2[k]))
            if res < sameLen:
                res = sameLen
                subLis1 = dic1[k]
                subLis2 = dic2[k]
    print(res)
    if res != 0:
        myPrint(subLis1, res)
        myPrint(subLis2, res)
    return

func()