class Solution:
    def truncateSentence(self, s: str, k: int) -> str:
        s_lis = s.split(' ')
        return ' '.join(s_lis[:k])