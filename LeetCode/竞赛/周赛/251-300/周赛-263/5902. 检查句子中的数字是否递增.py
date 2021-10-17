class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        lis = s.split()
        l = 0
        for ss in lis:
            try:
                val = int(ss)
                if val <= l:
                    return False
                l = val
            except:
                pass
        return True