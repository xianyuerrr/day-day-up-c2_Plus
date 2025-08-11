from typing import List


class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        res = 0
        cur = 0
        for tr in trainers:
            if (cur >= len(players)):
                break
            if tr >= players[cur]:
                cur += 1
                res += 1
        return res