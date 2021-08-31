class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        def xz(mat):
            m, n = len(mat), len(mat[0])
            new_mat = [[0 for _ in range(n)] for __ in range(m)]
            for i in range(m//2 if m % 2 == 0 else m//2+1):
                for j in range(n//2 if n % 2 == 0 else n//2+1):
                    new_mat[i][j], new_mat[j][n-1-i], new_mat[m-1-i][n-1-j], new_mat[m-1-j][i] = \
                        mat[m-1-j][i], mat[i][j], mat[j][n-1-i], mat[m-1-i][n-1-j]
            return new_mat
        
        def equal(mat1, mat2):
            m1, n1 = len(mat1), len(mat1[0])
            m2, n2 = len(mat2), len(mat2[0])

            if m1 != m2 or n1 != n2:
                return False
            for i in range(m1):
                for j in range(n1):
                    if mat1[i][j] != mat2[i][j]:
                        return False
            return True
        mat_90 = xz(mat)
        mat_180 = xz(mat_90)
        mat_270 = xz(mat_180)
        return equal(mat, target) or equal(mat_90, target) or equal(mat_180, target) or equal(mat_270, target)