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

    beUse1 = defaultdict(list)
    for i in range(m):
        for j in range(i+1, m):
            diff = s1[j] - s1[i]
            if i in beUse1[diff]:
                continue
            subLis = [s1[i], s1[j]]
            beUse1[diff].append(i)
            beUse1[diff].append(j)
            for k in range(j+1, m):
                if s1[k] - subLis[-1] == diff:
                    beUse1[diff].append(k)
                    subLis.append(s1[k])
            if len(dic1[diff]) == 0 or len(subLis) > len(dic1[diff][-1]):
                dic1[diff].append(subLis)

    beUse2 = defaultdict(list)
    for i in range(n):
        for j in range(i+1, n):
            diff = s2[j] - s2[i]
            if i in beUse2[diff]:
                continue
            subLis = [s2[i], s2[j]]
            beUse2[diff].append(i)
            beUse2[diff].append(j)
            for k in range(j+1, n):
                if s2[k] - subLis[-1] == diff:
                    beUse2[diff].append(k)
                    subLis.append(s2[k])
            if len(dic2[diff]) == 0 or len(subLis) > len(dic2[diff][-1]):
                dic2[diff].append(subLis)
    res = 0
    subLis1 = []
    subLis2 = []

    for k, v in dic1.items():
        if k in dic2:
            length1 = len(dic1[k])
            length2 = len(dic2[k])
            i = j = 0
            while i < length1 and j < length2:
                if len(dic1[k][i]) < len(dic2[k][j]):
                    i += 1
                    if i == length1:
                        i = length1-1
                        break
                else:
                    j += 1
                    if j == length2:
                        j = length2-1
                        break
            sameLen = min(len(dic1[k][i]), len(dic2[k][j]))
            if res < sameLen:
                res = sameLen
                subLis1 = dic1[k][i]
                subLis2 = dic2[k][j]
    print(res)
    if res != 0:
        myPrint(subLis1, res)
        myPrint(subLis2, res)
    return

func()