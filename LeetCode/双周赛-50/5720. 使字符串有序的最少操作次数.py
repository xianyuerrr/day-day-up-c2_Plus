import collections
import math
class Solution:
    def makeStringSorted(self, s: str) -> int:
        # 求字符串的总共组合数量，用到了那个先验知识
        cnt = collections.Counter(s)
        cur = math.factorial(len(s))
        for v in cnt.values():
            cur //= math.factorial(v)

        res = 0
        for i, v in enumerate(s):
            for ke, va in cnt.items():
                # 当后续某个字符小于当前字符，累加当前的可能性
                # 以上面的描述为例，当b后面出现个a，可以假定当前位置变成a，这种情况下
                # 还剩下 (x - 1)个a，y个b，z个c, 组合总数为 ((x - 1) + y + z)! / ((x - 1)! * y! * z!)
                # 等同为 (x + y + z)! / (x! * y! * z!) * x / (x + y + z)
                # 也就是下面的 cur * va // (len(s) - i)
                if ke < v:
                    res += cur * va // (len(s) - i)

            # 当字符往后移动时，更新当前的可能的组合数，同时更新Counter
            cur = cur * cnt[v] // (len(s) - i)
            cnt[v] -= 1

        return res % (10 ** 9 + 7)
