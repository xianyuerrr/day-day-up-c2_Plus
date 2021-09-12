class LockingTree:
    def __init__(self, parent: List[int]):
        self.n = len(parent)
        self.parent = parent

        self.locks = [False] * self.n
        self.lock_user = [0] * self.n
        
        self.sons = [[] for _ in range(self.n)]
        for i in range(self.n):
            if self.parent[i] != -1:
                self.sons[self.parent[i]].append(i)


    def lock(self, num: int, user: int) -> bool:
        if self.locks[num]:
            return False
        self.locks[num] = True
        self.lock_user[num] = user
        return True

    def unlock(self, num: int, user: int) -> bool:
        if not self.locks[num] or self.lock_user[num] != user:
            return False
        self.locks[num] = False

        return True
        

    def upgrade(self, num: int, user: int) -> bool:
        if self.locks[num]:
            return False
        # 寻找父节点，并判断其是否被锁
        idx = num
        while idx != -1 and not self.locks[idx]:
            idx = self.parent[idx]
        # 艹，竟然是这里没有考虑 idx 等于 -1 的情况
        if idx != -1 and self.locks[idx]:
            return False

        flag = False # 记录是否有子节点被锁
        q = [num]
        new_q = []
        lockedSons = []
        while q:
            for idx in q:
                if self.locks[idx]:
                    flag = True
                    lockedSons.append(idx)
                new_q += self.sons[idx]
            q.clear()
            q, new_q = new_q, q
        if not flag:
            return False

        for idx in lockedSons:
            self.locks[idx] = False

        self.lock(num, user)
        return True
        