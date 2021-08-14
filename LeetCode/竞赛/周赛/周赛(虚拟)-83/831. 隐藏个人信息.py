class Solution:
    def mail(self, s):
        s_lis = s.split('@')
        s_lis[0] = s_lis[0][0] + '*' * 5 + s_lis[0][-1]
        new_s = '@'.join(s_lis)
        return new_s.lower()

    def phone_number(self, s):
        s_lis = []
        for i in s:
            if '0' <= i <= '9':
                s_lis.append(i)
        new_s = ''.join(s_lis)
        head = new_s[:-10]
        tail = "***-***-" + new_s[-4:]
        if len(head) == 0:
            res = tail
        else:
            res = '+' + '*' * len(head) + '-' + tail
        return res

    def maskPII(self, S: str) -> str:
        if '@' in S:
            s = self.mail(S)
        else:
            s = self.phone_number(S)
        return s
