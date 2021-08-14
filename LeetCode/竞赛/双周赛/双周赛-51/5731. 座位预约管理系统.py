from heapq import *
class SeatManager:

    def __init__(self, n: int):
        self.p = [i for i in range(1, n+1)]
        heapify(self.p)


    def reserve(self) -> int:
        return heappop(self.p)

    def unreserve(self, seatNumber: int) -> None:
        heappush(self.p, seatNumber)


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)