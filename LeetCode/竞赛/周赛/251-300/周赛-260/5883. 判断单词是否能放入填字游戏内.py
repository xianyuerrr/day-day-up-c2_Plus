class Solution:
    def placeWordInCrossword(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])

        k = len(word)
        nextR = [[1 for j in range(n)] for i in range(m)]
        nextD = [[1 for j in range(n)] for i in range(m)]
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if board[i][j] == '#':
                    nextR[i][j] = 0
                    nextD[i][j] = 0
                else:
                    if j < n-1:
                        nextR[i][j] = nextR[i][j+1] + 1
                    if i < m-1:
                        nextD[i][j] = nextD[i+1][j] + 1
        # print(nextR)
        # print(nextD)
        for i in range(m):
            for j in range(n):
                if (i == 0 or board[i-1][j] == '#') and nextD[i][j] == k:
                    for idx in range(k):
                        if board[i+idx][j] == ' ' or board[i+idx][j] == word[idx]:
                            continue
                        else:
                            break
                    else:
                        return True

                    for idx in range(k):
                        if board[i+k-1-idx][j] == ' ' or board[i+k-1-idx][j] == word[idx]:
                            continue
                        else:
                            break
                    else:
                        return True
                if (j == 0 or board[i][j-1] == '#') and nextR[i][j] == k:
                    for idx in range(k):
                        if board[i][j+idx] == ' ' or board[i][j+idx] == word[idx]:
                            continue
                        else:
                            break
                    else:
                        return True

                    for idx in range(k):
                        if board[i][j+k-1-idx] == ' ' or board[i][j+k-1-idx] == word[idx]:
                            continue
                        else:
                            break
                    else:
                        return True
        return False
