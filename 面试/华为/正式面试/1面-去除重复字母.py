from collections import Counter
s = "abacb"
counter = Counter(s)

# 强大的单调栈
stk = []
have = [False] * 26
for c in s:
    counter[c] -= 1
    if have[ord(c)-ord('a')]:
        continue
    while stk and c < stk[-1] and counter[stk[-1]] > 0:
        have[ord(stk.pop()) - ord('a')] = False

    have[ord(c)-ord('a')] = True
    stk.append(c)

print(''.join(stk))

# 题源： https://leetcode-cn.com/problems/remove-duplicate-letters/