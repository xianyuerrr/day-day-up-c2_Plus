class StockSpanner:

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        idx = len(self.stack) - 1
        while idx != -1 and price >= self.stack[idx][1]:
            idx = self.stack[idx][0]
        self.stack.append((idx, price))
        return len(self.stack)-1 - idx
        


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)