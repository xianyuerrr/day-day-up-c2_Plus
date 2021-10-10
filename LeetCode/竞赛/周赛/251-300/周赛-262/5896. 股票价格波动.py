from heapq import heappush, heappop
from collections import defaultdict
from typing import *

class StockPrice:
    def __init__(self):
        self.time = -1
        self.cur = -1
        self.dic = defaultdict(int)
        self.maxQ = []
        self.minQ = []
        self.cnt = defaultdict(int)

    def update(self, timestamp: int, price: int) -> None:
        # 因为这里的等号 卡了 两次，太粗心了
        if self.time == -1 or self.time <= timestamp:
            self.time = timestamp
            self.cur = price
            
        if self.dic[timestamp] != 0:
            old = self.dic[timestamp]
            self.cnt[old] -= 1
        self.dic[timestamp] = price
        self.cnt[price] += 1

        while self.maxQ and self.cnt[-self.maxQ[0]] == 0:
            heappop(self.maxQ)
        while self.minQ and self.cnt[self.minQ[0]] == 0:
            heappop(self.minQ)
        heappush(self.maxQ, -price)
        heappush(self.minQ, price)


    def current(self) -> int:
        return self.cur

    def maximum(self) -> int:
        return -self.maxQ[0]

    def minimum(self) -> int:
        return self.minQ[0]


# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()