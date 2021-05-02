from bisect import insort, bisect

class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        rooms.sort(key=lambda x : (x[1], x[0]), reverse=True)
        res = [None for _ in range(len(queries))]
        # 都按照房间大小 从大到小排序
        new_queries = [[queries[i], i] for i in range(len(queries))]
        new_queries.sort(key=lambda x: (x[0][1]), reverse=True)

        p = []
        m = len(rooms)
        room_idx = 0
        # 由于已经从大到小排过序，所以之前插入 p 中的房间依然满足当前的 最小面积要求
        for querie, idx in new_queries:
            preferred, min_size = querie
            while room_idx < m and rooms[room_idx][1] >= min_size:
                room_id = rooms[room_idx][0]
                insort(p, room_id)
                room_idx += 1

            
            if p:
                ans = bisect(p, preferred)
                # 二分查找，ans左侧  < preferred, 右侧 >= preferred
                # 如果 ans == len(p)，说明所有元素都小于 preferred，取最后一个
                # 如果 ans == 0， 说明所有元素都大于 preferred，取第一个
                # 0 < ans < len(p)，只用判断 ans 和 ans-1 两个位置
                # 差的绝对值有 相等 的，选择 最小 的 id，所以相等时要选 ans-1
                if ans == len(p) or \
                    (ans > 0 and abs(p[ans] - preferred) >= abs(p[ans-1] - preferred)):
                    ans -= 1
                res[idx] = p[ans]
            else:
                res[idx] = -1 
        return res
