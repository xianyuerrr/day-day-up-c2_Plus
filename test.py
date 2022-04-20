lis = [1, 20, 3, 20, 21, 14, 2, 3, 4, 6, 7, 8, 22, 23, 9, 10, 11, 13, 12, 13, 14, 15, 18, 19, 15, 18, 19, 19, 16, 18, 19]
res = []
for i in lis:
    if i in res:
        pass
    else:
        res.append(i)
for i in range(len(res)):
    print("old: ", res[i], " new: ", i+1)
