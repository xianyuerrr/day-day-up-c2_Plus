class Solution:
    def longestBeautifulSubstring(self, word: str) -> int:
        n = len(word)
        res = 0
        
        status = 'x'
        cur = 0
        # 改进状态机
        status_set = {('x', 'a'), ('a', 'a'), ('a', 'e'), ('e', 'e'), 
                        ('e', 'i'), ('i', 'i'), ('i', 'o'), ('o', 'o'), 
                        ('o', 'u'), ('u', 'u')}
        for i in word:
            if (status, i) in status_set:
                cur += 1
                status = i
                if status == 'u':
                    res = max(res, cur)
            else:
                if i == 'a':
                    status = 'a'
                    cur = 1
                else:
                    status = 'x'
                    cur = 0
        return res

        # 状态机
        # for idx in range(n):
        #     if word[idx] == 'a':
        #         if status == 'a' or status == 'x':
        #             status = 'a'
        #             cur += 1
        #         else:
        #             cur = 0
        #             status = 'x'
        #     elif word[idx] == 'e':
        #         if status == 'a' or status == 'e':
        #             status = 'e'
        #             cur += 1
        #         else:
        #             status = 'x'
        #             cur = 0
        #     elif word[idx] == 'i':
        #         if status == 'e' or status == 'i':
        #             status = 'i'
        #             cur += 1
        #         else:
        #             status = 'x'
        #             cur = 0
        #     elif word[idx] == 'o':
        #         if status == 'i' or status == 'o':
        #             status = 'o'
        #             cur += 1
        #         else:
        #             status = 'x'
        #             cur = 0
        #     elif word[idx] == 'u':
        #         if status == 'o' or status == 'u':
        #             status = 'u'
        #             cur += 1
        #             res = max(res, cur)
        #         else:
        #             status = 'x'
        #             cur = 0
        # return res

        # 隐式滑窗
        # 1.首先如果数组长度小于5的话，不可能满足美丽的定义，将这种情况提前排除
        # 2.遍历时分了几种情况判断：
        #     - 如果当前字符比上一个不小（顺序意义），那么当前子串长度+1
        #     - 如果当前字符比上一个大，那么子串中元音字母种类+1
        #     - 如果当前字符比上一个小，那么肯定当前字串不美丽，以当前字符为首继续进行遍历
        # 3.如果当前子字符串没有以a开头的话，那么在进行下一个子字符串开始遍历之前，元音种类一定不会达到5，所以只要判断种类即可
        # 4.当元音种类为5的时候，持续维护更新最终结果，取出最大值即可

        # length = 1
        # have = 1
        # for i in range(1, n):
        #     if word[i] > word[i-1]:
        #         have += 1
        #         length += 1
        #     elif word[i] == word[i-1]:
        #         length += 1
        #     else:
        #         if have == 5:
        #             res = max(res, length)
        #         have = 1
        #         length = 1
        #     if have == 5:
        #             res = max(res, length)
        # return res

        # # 朴素滑动窗口
        # dic = {'a':0, 'e':1, 'i':2, 'o':3, 'u':4}
        # count = [0 for i in range(5)]
        # left = 0
        # count[dic[word[left]]] += 1
        # for right in range(1, n):
        #     count[dic[word[right]]] += 1
        #     while left < right and word[left] != 'a':
        #         count[dic[word[left]]] -= 1
        #         left += 1
        #     if word[right] < word[right - 1]:
        #         count = [0 for i in range(5)]
        #         left = right
        #         count[dic[word[right]]] += 1
        #         continue
        #     if word[right] == 'u':
        #         for i in count:
        #             if i == 0:
        #                 break
        #         else:
        #             res = max(res, right-left+1)
        # return res
                