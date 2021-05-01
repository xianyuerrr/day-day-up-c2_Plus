from heapq import *
class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        rooms.sort(key=lambda x : (x[1], x[0]), reverse=True)
        res = []
        for i in range(len(queries)):
            preferred, min_size = queries[i]
            p = []
            for room_id, room_size in rooms:
                if room_size < min_size:
                    break
                else:
                    heappush(p, (abs(preferred - room_id), room_id))
            
            if p:
                val, room_id = heappop(p)
                res.append(room_id)
            else:
                res.append(-1)
        return res
