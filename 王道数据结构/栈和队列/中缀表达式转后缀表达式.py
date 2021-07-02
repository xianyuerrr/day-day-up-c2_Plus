icp = {'#' : 0, '(' : 6, '*' : 4, '/' : 4, '+' : 2, '-' : 2, ')' : 1}
isp = {'#' : 0, '(' : 1, '*' : 5, '/' : 5, '+' : 3, '-' : 3, ')' : 6}
# 栈外(in coming priority)优先数、
# 栈内(in stack priority)优先数
stk = []
stk.append('#')
res = []
s = "a+b*c-d"
for i in (s+'#'):
    print(res, stk, i)
    if i not in icp:
        res.append(i)
    else:
        if icp[i] > isp[stk[-1]]:
            stk.append(i)
        elif icp[i] < isp[stk[-1]]:
            while icp[i] < isp[stk[-1]]:
                res.append(stk.pop())
            stk.append(i)
        elif icp[i] == isp[stk[-1]]:
            stk.pop()
print(''.join(res))