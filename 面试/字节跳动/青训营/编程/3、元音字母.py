dic = set(['A', 'E', 'I', 'O', 'U'])
s = input()
n = len(s)
l = -1
res = -1
for i in range(n):
    if s[i] in dic:
        if l == -1:
            pass
        else:
            res = max(res, i-l)
        l = i
print(res)
            