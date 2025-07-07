from collections import Counter
from typing import List


class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        freq = Counter(words)   # 单词出现次数
        res = 0   # 最长回文串长度
        mid = False   # 是否含有中心单词
        for word, cnt in freq.items():
            # 遍历出现的单词，并更新长度
            rev = word[1] + word[0]   # 反转后的单词
            if word == rev:
                if cnt % 2 == 1:
                    mid = True
                res += 2 * (cnt // 2 * 2)
            elif word > rev:   # 避免重复遍历
                res += 4 * min(freq[word], freq[rev])
        if mid:
            # 含有中心单词，更新长度
            res += 2
        return res
