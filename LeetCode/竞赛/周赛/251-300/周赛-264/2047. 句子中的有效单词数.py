from typing import*

class Solution:
    def checkWord(self, word) -> bool:
        if len(word) > 1 and not word[0].isalpha():
            return False
        if word[0] == '-' or word[-1] == '-':
            return False
        flag = False
        for idx in range(len(word)):
            s = word[idx]
            if s.isalpha():
                pass
            elif s.isdigit():
                return False
            elif s == '-':
                if flag:
                    return False
                flag = True
                if not (word[idx-1].isalpha() and word[idx+1].isalpha()):
                    return False
            else:
                if idx != len(word) - 1:
                    return False
        return True

    def countValidWords(self, sentence: str) -> int:
        res = 0
        lis = sentence.split()
        for word in lis:
            if self.checkWord(word):
                res += 1
        return res