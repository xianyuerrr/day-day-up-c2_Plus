class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        dic = defaultdict(int)
        n = len(words)
        for word in words:
            for s in word:
                dic[s] += 1
        for k, v in dic.items():
            if v % n != 0:
                return False
        return True