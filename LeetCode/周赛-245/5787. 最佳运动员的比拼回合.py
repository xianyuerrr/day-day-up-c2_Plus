class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        return[self.earliest(n, firstPlayer, secondPlayer), self.latest(n, firstPlayer, secondPlayer)]

    def earliest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        if firstPlayer > secondPlayer:
            return self.earliestAndLatest(n, firstPlayer, secondPlayer)
        l = firstPlayer - 1
        r = n - secondPlayer
        if l == r:
            return 0
        elif l < r:
            if r-1-2*l > 0:
                l = l+1
                r = r-1-2*l+1
            return self.earliest(n//2 if n%2==0 else n//2+1, l, r) + 1
        else:

    def latest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        if firstPlayer > secondPlayer:
            return self.earliestAndLatest(n, firstPlayer, secondPlayer)
        l = firstPlayer - 1
        r = n - secondPlayer
        if l < r:
            