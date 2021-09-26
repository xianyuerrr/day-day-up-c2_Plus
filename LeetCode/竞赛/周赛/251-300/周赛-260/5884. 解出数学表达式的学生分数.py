from collections import defaultdict, Counter
class Solution:
    def scoreOfStudents(self, s: str, answers: List[int]) -> int:
        # 由于加法和乘法有交换律，所以连续的加法、乘法内的次序无关紧要，
        # 主要是加法和乘法之间次序的打乱
        trueRes = 1
        stk = []
        signal = []
        dic = defaultdict(int)
        counter = Counter(answers)

        for i in s:
            if i == '+' or i == '*':
                signal.append(i)
            else:
                if signal and signal[-1] == '*':
                    stk[-1] *= int(i)
                    signal.pop()
                else:
                    stk.append(int(i))
        trueRes = sum(stk)
        stk.clear()
        signal.clear()

        for i in s:
            if i == '+' or i == '*':
                signal.append(i)
            else:
                stk.append(int(i))
        


        res = 0
        for k, v in counter:
            if k == trueRes:
                res += 5 * v
            elif k in dic:
                res += 2 * v
        return res