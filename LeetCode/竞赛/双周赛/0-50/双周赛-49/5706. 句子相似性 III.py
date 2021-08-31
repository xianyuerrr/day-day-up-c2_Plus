class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        if not sentence1 or not sentence2:
            return False
        # 转成 list 方便进行处理
        st1_lis = sentence1.split(' ')
        st2_lis = sentence2.split(' ')
        st1_len = len(st1_lis)
        st2_len = len(st2_lis)

        # 长度相同，则只能添加无意义的空白，所以直接比较
        if st1_len == st2_len:
            return st1_lis == st2_lis
        # 统一情况
        if st1_len > st2_len:
            st1_lis, st1_len ,st2_lis, st2_len = \
                st2_lis, st2_len, st1_lis, st1_len
        # 列表长度为 1 的比较特殊,可能处于较长 list 的两端
        if st1_len == 1:
            return st1_lis[0] in (st2_lis[0], st2_lis[-1])
        // 需要忽略 st2_len - st1_len 个项
        # 以当前 idx 为起点,向后 st1_len 的长度作为匹配项
        for i in range(st2_len - st1_len):
            print(st2_lis[i : i + st1_len])
            if st2_lis[i : i + st1_len] == st1_lis:
                return True
        # 以当前 idx 为起点,往前忽略 长度为 st1_len 的语句
        for i in range(st2_len - st1_len, st2_len):
            print(st2_lis[:i-(st2_len - st1_len)] + st2_lis[i:])
            if st2_lis[:i-(st2_len - st1_len)] + st2_lis[i:] == st1_lis:
                return True
        return False