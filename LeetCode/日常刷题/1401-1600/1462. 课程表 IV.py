from typing import List


class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        f = [[False] * numCourses for _ in range(numCourses)]
        for i, j in prerequisites:
            f[i][j] = True

        # Floyd算法
        for k in range(numCourses):
            for i in range(numCourses):
                for j in range(numCourses):
                    if (f[i][k] and f[k][j]):
                        f[i][j] = True
        return [f[i][j] for i, j in queries]