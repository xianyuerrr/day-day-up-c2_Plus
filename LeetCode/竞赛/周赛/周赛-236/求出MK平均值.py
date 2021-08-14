class MKAverage:

    def __init__(self, m: int, k: int):
        self.m = m
        self.k = k
        self.lis = []
        self.len = 0

    def addElement(self, num: int) -> None:
        self.lis.append(num)
        self.len += 1

    def calculateMKAverage(self) -> int:
        m = self.m
        k = self.k
        if self.len < m:
            return -1
        new_lis = self.lis[-m:]
        new_lis.sort()
        res = sum(new_lis[k:-k]) / (m-2*k)
        c_r = floor(res)
        res = c_r
        return res



# Your MKAverage object will be instantiated and called as such:
# obj = MKAverage(m, k)
# obj.addElement(num)
# param_2 = obj.calculateMKAverage()